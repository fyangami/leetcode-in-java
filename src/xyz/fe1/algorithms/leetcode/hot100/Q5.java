package xyz.fe1.algorithms.leetcode.hot100;

//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3439 👎 0
public class Q5 {

    public static void main(String[] args) {
        var q5 = new Q5();
        System.out.println(q5.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        String found = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (var k = 0; k < s.length(); ++k) {  // k（子串长度） 按照子串的长度从1到n-1遍历
            for (var i = 0; i + k < s.length(); ++i) {    // i,j 遍历坐标，保证对比的始终是字串的首位和末位
                int j = k + i;  // 计算访问步长
                if (k == 0) {  // 长度为1则一定是回文子串
                    dp[i][j] = true;
                } else {
                    var b = s.charAt(i) == s.charAt(j);
                    if (k == 1) {   // 长度为2若 i,j 相等则一定是子串
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = b && dp[i + 1][j - 1];  // 长度大于2则取决于首尾字符是否相等和其子串是否是回文子串
                    }
                }
                if (dp[i][j] && k + 1 > found.length()) {
                    found = s.substring(i, i + k + 1);  // 根据坐标取出回文子串
                }
            }
        }
        return found;
    }

    public String ttes(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {
                        dp[i][j] = b;
                    } else {
                        dp[i][j] = (b && dp[i + 1][j - 1]);
                    }
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}
