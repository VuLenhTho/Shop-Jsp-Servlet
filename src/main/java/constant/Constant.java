package constant;

public class Constant {
    public static final String TYPE = "type";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_CREATE = "create";
    public static final String EMPTY = "";

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static boolean isEmpty(String string) {
        return EMPTY.equals(string);
    }
}
