package xyz.fe1.algorithms.leetcode.hot100;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2318 👎 0
public class Q11 {

    public static void main(String[] args) {
        var q11 = new Q11();
        System.out.println(q11.maxArea2(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(q11.maxArea2(new int[] {1, 2, 1}));
        System.out.println(q11.maxArea2(new int[] {4, 3, 2, 1, 4}));
        System.out.println(q11.maxArea2(new int[] {1, 1}));
    }

    /**
     * 双指针
     * 核心，小的一边移动，首尾双向遍历
     */
    public int maxArea2(int[] height) {
        int max = 0;
        int left, right = height.length - 1;
        for (left = 0; left != right;) {
            var h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            if (height[left] == h) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    /**
     * 暴力解法，超时
     */
    // [1,8,6,2,5,4,8,3,7]  49
    public int maxArea(int[] height) {
        int max = 0;
        int i, j;
        for (i = 0; i < height.length; ++i) {
            for (j = i + 1; j < height.length; ++j) {
                var h = Math.min(height[i], height[j]);
                max = Math.max(max, h * (j - i));
            }
        }
        return max;
    }

}
