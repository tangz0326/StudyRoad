package 简单的算法;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] str = {"arrewrre43", "arrewreek", "arrekewrewrelre2", "arrerewkre4", "arrewq"};
//        System.out.println("最小位数："+getMinLength(str));
        System.out.println("结果为："+solution(str));
    }

    public static int getMinLength(String[] strArr) {
        int result = 0;
        for (int i = 0; i < strArr.length - 1; i++) {
            if (strArr[i].toCharArray().length < strArr[i + 1].toCharArray().length) {
                strArr[i + 1] = strArr[i];
            }
        }
        return strArr[strArr.length - 1].toCharArray().length;
    }

    public static String solution(String[] strArr) {
        String[] newStr=strArr.clone();
        int len=getMinLength(newStr);
        String s = "www";
        String result = "";
        for (int i = 0; i < len-1; i++) {
            s = strArr[0].substring(0, i+1);
            List<String> list = new ArrayList<>();
            for (int j = 1; j < strArr.length; j++) {
                if (strArr[j].substring(0, i+1).equals(s)) {
                    list.add(strArr[j]);
                }

            }
            if (list.size() == (strArr.length - 1)) {
                result = s;
            }
        }

        return result;
    }
}
