package security;

import javax.servlet.http.HttpServletRequest;

public interface Authentication {
    static Authentication newModel(String userName, String password){
        return new AuthenticationImpl(userName,password);
    }

    String urlRedirect(HttpServletRequest request);
}
