package 简单的算法;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 八大排序 {
    public static void main(String[] args) {
        maopaoSort(new Integer[]{10,9,8,7,6,5,4,3,2,1});
    }

    /**
     * 冒泡排序
     */
    public static void maopaoSort(Integer[] arr){
        int times=arr.length-1;
        for(int i=0;i<times;i++){
            if(arr[i]>arr[i+1]){
                int temps=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temps;
            }
            if(i==times-1){
                i=-1;
                times--;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}
