package 简单的算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *   $全量的反转可能会造成数据溢出$
 */
public class 回文数 {
    public static void main(String[] args) {
//        System.out.println(solution_1(15222251));
//        System.out.println(solution_2(812222218));
        System.out.println(solution_3(17899871));
    }


    public static boolean solution_1(int i) {
        char[] arr = String.valueOf(i).toCharArray();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            list1.add(arr[j]);
        }
        for (int k = arr.length - 1; k >= 0; k--) {
            list2.add(arr[k]);
        }
        for (int m = 0; m < arr.length; m++) {
            if (list1.get(m) != list2.get(m)) {
                return false;
            }
        }
        return true;
    }

    public static boolean solution_2(int i) {
        String sb=new StringBuffer(i+"").reverse().toString();
        System.out.println(sb);
        return sb.equals(String.valueOf(i));
    }

    public static boolean solution_3(int i){
        int s=0;
        int x=i;
        while (x>0){
            s=s*10+x%10;
            x=x/10;
        }
        return s==i;
    }


}