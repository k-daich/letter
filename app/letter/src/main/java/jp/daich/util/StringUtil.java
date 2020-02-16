package jp.daich.util;

public class StringUtil {

    // 空文字
    public static final String EMPTY = "";

    /**
     * Invalidate Constructor
     */
    private StringUtil() {
        throw new UnsupportedOperationException();
    }

    /**
     * nullもしくは空文字の場合にtrueを返す
     * @param str
     * @return is empty
     */
    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    /**
     * nullもしくは空文字の場合にfalseを返す
     * @param str
     * @return is not empty
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}