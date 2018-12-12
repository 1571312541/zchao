package cn.clj.zchao.util;

public class StringUtil {

    public StringUtil() {
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() != 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
