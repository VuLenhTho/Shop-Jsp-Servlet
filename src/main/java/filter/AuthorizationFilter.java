package filter;

import model.AccountModel;
import model.RoleModel;
import service.IRoleService;
import service.impl.RoleServiceImpl;
import utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private ServletContext context;
    private IRoleService roleService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context =filterConfig.getServletContext();
        roleService = new RoleServiceImpl();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        AccountModel accountModel = (AccountModel) SessionUtil.getValue(req,"USER");
        String url = req.getRequestURI();
        if (url.startsWith("/admin")){
            if (accountModel != null){
                RoleModel roleModel = roleService.findByID(accountModel.getRoleID());
                if (roleModel.getRoleName().equals("admin")){
                    chain.doFilter(req,resp);
                }else if (roleModel.getRoleName().equals("editor") && (url.startsWith("/admin/product") || url.equals("/admin"))){
                    chain.doFilter(req,resp);
                }else {
                    resp.sendRedirect("/login?message=permissionDenied");
                }
            }else {
                resp.sendRedirect("/login?message=dontLogin");
            }
        }else {
            chain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
