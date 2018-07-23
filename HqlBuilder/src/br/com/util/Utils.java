package br.com.util;

public final class Utils {

    public static final String SPACE = " ";
    public static final String COMMA = ",";
    public static final String OPEN_PARENTHESES = "(";
    public static final String CLOSE_PARENTHESES = ")";


    public static boolean isNull(Object obj) {
        return null == obj;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean hasNotNull(Object... obj) {
        for (Object o : obj) {
            if (isNotNull(o)) {
                return true;
            }
        }
        return false;
    }

    public static void verifyFieldsToBeReturned(String... fields) {
        if (fields.length == 0) {
            throw new NullPointerException("No fields in selection, null");
        }
    }

}
