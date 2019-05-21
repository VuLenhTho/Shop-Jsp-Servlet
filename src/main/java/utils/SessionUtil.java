package utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static void putValue(HttpServletRequest request, String key, Object value){
        request.getSession().setAttribute(key,value);
    }

    public static Object getValue(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }

    public static void removeValue(HttpServletRequest request,String key){
        request.getSession().removeAttribute(key);
    }
}
