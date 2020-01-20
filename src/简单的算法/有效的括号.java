package 简单的算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        String str = "((){}[[{)}";
        String str2 = "()()()({[]})[{()}]";
        System.out.println(isValid(str2));
    }

    public static boolean isValid(String str) {
        assert str != null;  //断言语法  assert[boolean 表达式] 如果boolean表达式为true,则程序继续执行；如果为false 则程序抛出java.lang.assertionError 错误信息
        if (str.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char res = str.charAt(i);
            if (res == '(' || res == '[' || res == '{' && stack.size() < (str.length() - i)) {
                stack.push(res);
                continue;
            }
            if (!stack.empty() && res == map.get(stack.pop())) {
                continue;
            }

            return false;   //字符串第一元素为'右括号'时，在这里直接返回false不用再去执行下一步判断，否则虽然结果不影响，但是会做很多没有必要的判断。
        }

        return stack.empty();
    }


    /**
     * 官方解题
     */
    public boolean isValid2(String s) {
        assert s != null;
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '(' || c == '[' || c == '{') && stack.size() < s.length() - i) {
                stack.push(c);
                continue;
            }
            if (!stack.empty() && c == map.get(stack.pop())) {
                continue;
            }

            return false;
        }

        return stack.empty();
    }


}

