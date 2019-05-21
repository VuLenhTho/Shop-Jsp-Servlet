package controller.web;

import model.request.AccountRequest;
import security.Authentication;
import service.IAccountService;
import service.IRoleService;
import service.impl.AccountServiceImpl;
import service.impl.RoleServiceImpl;
import utils.MapClientToServerUtil;
import utils.SessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    private IAccountService accountService;
    private IRoleService roleService;

    public LoginController() {
        accountService = new AccountServiceImpl();
        roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        String action = req.getParameter("action");
        if (message != null) {
            if (message.equals("loginError")) {
                req.setAttribute("message", "Tài khoản hoặc mật khẩu bị sai");
            } else if (message.equals("permissionDenied")) {
                req.setAttribute("message", "Bạn không đủ quyền truy cập vào trang này");
            } else if (message.equals("dontLogin")) {
                req.setAttribute("message", "Bạn chưa đăng nhập");
            }
        }
        if (action != null && action.equals("logout")) {
            resp.sendRedirect("/trangChu");
            SessionUtil.removeValue(req, "USER");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountRequest accountRequest = MapClientToServerUtil.toModel(AccountRequest.class,req);
        String url = Authentication.
                newModel(accountRequest.getUserName(),accountRequest.getPassword()).urlRedirect(req);
        resp.sendRedirect(url);
    }
}
