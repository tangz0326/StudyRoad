package 简单的算法;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] str = {"arrejjjwrre43", "arrejjjwreek", "arrejjjkewrewrelre2", "arrejjjrewkre4", "arrejjjwq"};
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
        String s = "";
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


/**
 * 官方题解
 */
class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}
