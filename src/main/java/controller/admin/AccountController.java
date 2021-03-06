package controller.admin;

import constant.Constant;
import model.AccountModel;
import model.RoleModel;
import model.response.ModelResponse;
import paging.PageRequest;
import service.IAccountService;
import service.IRoleService;
import service.impl.AccountServiceImpl;
import service.impl.RoleServiceImpl;
import utils.MapClientToServerUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/account")
public class AccountController extends HttpServlet {
    private IAccountService accountService;
    private IRoleService roleService;
    private String previousPage = "1";

    public AccountController() {
        accountService= new AccountServiceImpl();
        roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("page");
        if (previousPage != null){
            this.previousPage = currentPage;
        }
        String type = req.getParameter(Constant.TYPE);
        String view = Constant.EMPTY;
        if (type != null){
            req.setAttribute("previousPage",this.previousPage);
            if (type.equals(Constant.ACTION_EDIT)){
                String id = req.getParameter("id");
                if (!id.equals(Constant.EMPTY)){
                    long ID = Long.parseLong(id);
                    AccountModel accountModel = accountService.findByID(ID);
                    if (accountModel != null){
                        req.setAttribute("model",accountModel);
                        view = "/views/admin/account/edit_account.jsp";
                    }else {
                        req.setAttribute("message","AccountModel isn't exist");
                    }
                }
            }else if (type.equals(Constant.ACTION_CREATE)){
                view = "/views/admin/account/edit_account.jsp";
            }
        }else {
            view = "/views/admin/account/account_list.jsp";
        }
        PageRequest pageRequest = MapClientToServerUtil.toModel(PageRequest.class,req);
        List<AccountModel> accountModelList = accountService.findAllAccount(pageRequest);

        List<RoleModel> roleModelList = roleService.findAllRole();
        req.setAttribute("roleModelList",roleModelList);

        long totalItem = accountService.countAllAccount();
        long totalPage = (long) Math.ceil((double) totalItem/pageRequest.getLimit());
        ModelResponse<AccountModel> result = new ModelResponse<>();
        result.setPage(pageRequest.getPage());
        result.setData(accountModelList);
        result.setTotalPage(totalPage);
        result.setTotalItem(totalItem);
        req.setAttribute("models",result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
