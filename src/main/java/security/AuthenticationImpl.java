package security;

import model.AccountModel;
import model.RoleModel;
import model.request.AccountRequest;
import service.IAccountService;
import service.IRoleService;
import service.impl.AccountServiceImpl;
import service.impl.RoleServiceImpl;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements Authentication{
    private String userName;
    private String password;
    private IAccountService accountService;
    private IRoleService roleService;

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
        accountService = new AccountServiceImpl();
        roleService = new RoleServiceImpl();
    }


    @Override
    public String urlRedirect(HttpServletRequest request) {
        AccountModel accountModel = accountService.findByUserNameAndPassword(new AccountRequest(userName,password));
        if (accountModel == null){
            return "/login?message=loginError";
        }else {
            SessionUtil.putValue(request,"USER",accountModel);
            RoleModel roleModel = roleService.findByID(accountModel.getRoleID());
            if (roleModel.getRoleName().equals("admin") || roleModel.getRoleName().equals("editor") || roleModel.getRoleName().equals("saleMan")){
                return "/admin";
            }else if (roleModel.getRoleName().equals("customer")){
                return "/trangChu";
            }
        }
        return null;
    }
}
