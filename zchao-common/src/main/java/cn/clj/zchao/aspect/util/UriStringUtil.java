package cn.clj.zchao.aspect.util;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * 〈〉
 *
 * @author 22902
 * @create 2018/12/12
 */
public class UriStringUtil {
    /**
     * 替换掉HTML标签方法
     */
    public static String stripHtml(String html) {

        if (isBlank(html)){
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        String s = m.replaceAll("");
        return s;
    }

    /**
     * 缩略字符串（不区分中英文字符）
     * @param str 目标字符串
     * @param length 截取长度
     * @return
     */
    public static String abbr(String str, int length) {
        if (str == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int currentLength = 0;
            for (char c : stripHtml(StringEscapeUtils.unescapeHtml(str)).toCharArray()) {
                currentLength += String.valueOf(c).getBytes("GBK").length;
                if (currentLength <= length - 3) {
                    sb.append(c);
                } else {
                    sb.append("...");
                    break;
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
