package controller.admin.api;

import model.AccountModel;
import service.IAccountService;
import service.impl.AccountServiceImpl;
import utils.JsonToModelUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/api/admin/account")
public class AccountAPIController extends HttpServlet implements Serializable {
    private IAccountService accountService;

    public AccountAPIController() {
        accountService = new AccountServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        AccountModel accountModel = JsonToModelUtil.of(req.getReader()).toModel(AccountModel.class);
        accountService.insertAccount(accountModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        AccountModel accountModel = JsonToModelUtil.of(req.getReader()).toModel(AccountModel.class);
        accountService.updateAccount(accountModel);
    }
}
