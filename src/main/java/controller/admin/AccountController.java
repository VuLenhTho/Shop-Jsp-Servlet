package controller.admin;

import constant.Constant;
import model.AccountModel;
import model.RoleModel;
import service.IAccountService;
import service.IRoleService;
import service.impl.AccountServiceImpl;
import service.impl.RoleServiceImpl;

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

    public AccountController() {
        accountService= new AccountServiceImpl();
        roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AccountModel> accountModelList = accountService.findAllAccount();
        req.setAttribute("accountModelList",accountModelList);
        List<RoleModel> roleModelList = roleService.findAllRole();
        req.setAttribute("roleModelList",roleModelList);
        String type = req.getParameter(Constant.TYPE);
        String view = Constant.EMPTY;
        if (type != null){
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


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
