package 简单的算法;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class 搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    /**
     * 将所用情况列举的方法
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
            if (nums[i] == target) {
                return i;
            }
        }
        return 0;
    }


    public int solution(int[] nums, int target) {
        System.out.println("修改");
        return 0;
    }
}
