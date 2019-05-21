package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class MapClientToServerUtil {
    public static <T> T toModel(Class<T> tClass, HttpServletRequest request){
        try{
            T object = tClass.newInstance();
            BeanUtils.populate(object,request.getParameterMap());
            return object;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InstantiationException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }
}
