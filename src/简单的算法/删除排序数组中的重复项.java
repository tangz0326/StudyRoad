package 简单的算法;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Arrays;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int temps=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
               nums[temps]=nums[i+1];
                temps++;
            }
        }
        Arrays.stream(nums).limit(temps).forEach(System.out::println);

        return temps;
    }

    /**
     *官方题解
     *双指针解法
     */
    public static int solution(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
