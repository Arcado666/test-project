package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtils {
    public static String regex(String regex, String content, int i) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        String string=null;
        while (matcher.find()) {
           string = matcher.group(i);
        }
        
        return string;
    }

    public static void main(String args[]) {
        System.out.print(RegexUtils.regex("=(.*)", "P33326:=4****************8", 1));
 
    }
}
