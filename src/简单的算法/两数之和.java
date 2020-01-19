package 简单的算法;

import sun.util.resources.cldr.agq.CalendarData_agq_CM;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数之和
{
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
//        twoSum_1(nums,target);
//        twoSum_2(nums, target);
        twoSum_3(nums,target);
    }

    /**
     * @Description: 方法一：暴力法
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)的时间。因此时间复杂度为O(n^2)。
     *
     * 空间复杂度：O(1)
     * @Author: tangzhen
     * @CreateDate: 2019/12/18 19:09
     */
    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[j] + nums[i];
                if (temp == target) {
                    int[] result = {i, j};
                    System.out.println("下标为：（" + i + "," + j + "）");
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
     * @Description: 方法二：两遍 Hash表
     * 时间复杂度：O(n)，
     * 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)，所以时间复杂度为 O(n)。
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n个元素。
     * @Author: tangzhen
     * @CreateDate: 2019/12/19 9:38
     */
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int temp = target - nums[j];
            if (maps.containsKey(temp) && maps.get(temp) != j) {
                System.out.println("下标为：（" + j + "," + maps.get(temp) + ")");
                return new int[]{j, maps.get(temp)};
            }
        }
        throw new IllegalArgumentException("no solution");
    }

    /**
    * @Description:    方法三：一遍 Hash 表
    *时间复杂度：O(n)
    * 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
    *
    * 空间复杂度：O(n)
    * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。

    * @Author:         tangzhen
    * @CreateDate:     2019/12/19 9:56
    */
    public static int[] twoSum_3(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (maps.containsKey(temp)) {
                System.out.println("下标为：（" + maps.get(temp) + "," + i + ")");
                return new int[]{maps.get(temp),i};
            }
            maps.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution");
    }


}
