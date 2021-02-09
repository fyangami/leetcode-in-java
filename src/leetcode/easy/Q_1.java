import java.util.Arrays;
import java.util.Hashtable;

public class Q_1 {

  /**
   *   1. Two Sum
   * 
   *   Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   *   You may assume that each input would have exactly one solution, and you may not use the same element twice.
   *   You can return the answer in any order.
   *   Example 1:
   *     Input: nums = [2,7,11,15], target = 9
   *     Output: [0,1]
   *     Output: Because nums[0] + nums[1] == 9, we return [0, 1].
   *   Example 2:
   *     Input: nums = [3,2,4], target = 6
   *     Output: [1,2]
   *     Input: nums = [3,3], target = 6
   *     Output: [0,1]
   * @param args
   */
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum2(nums, target)));
  }

  /**
   * 解法一：穷举
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    var out = new int[2];
    int i,j;
    for (i = 0; i < nums.length; ++i) {
      for (j = i + 1; j < nums.length; ++j) {
        if (nums[i] + nums[j] == target) {
          out[0] = i;
          out[1] = j;
          return out;
        }
      }
    }
    return out;
  }

  /**
   * 核心问题：查找   target - x
   */
  public static int[] twoSum2(int[] nums, int target) {
    var table = new Hashtable<Integer, Integer>();
    int i;
    for (i = 0; i < nums.length; ++i) {
      Integer exist = table.get(target - nums[i]);
      if (exist == null) {
        table.put(nums[i], i);
      } else {
        return new int[]{exist, i};
      }
    }
    return new int[2];
  }
}