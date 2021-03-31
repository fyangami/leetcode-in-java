package xyz.fe1.algorithms.leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5225 👎 0
public class Q3 {

    public static void main(String[] args) {
        var q3 = new Q3();
        System.out.println(q3.lengthOfLongestSubstring("fyangami")); // adda
    }

    //输入: s = "abcabcbb"
    //输出: 3
    public int lengthOfLongestSubstring(String s) {
        var chars = s.toCharArray();
        var set = new HashSet<Character>();
        int right = -1, maxLength = 0;
        int left;
        for (left = 0; left < chars.length;++left) {
            if (left != 0) {
                set.remove(chars[left - 1]);
            }
            while (right + 1< chars.length && !set.contains(chars[right + 1])) set.add(chars[++right]);
            maxLength = Math.max(right - left + 1, maxLength);
        }
        return maxLength;
    }
}
