package xyz.fe1.algorithms.leetcode.hot100;

import java.util.LinkedList;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1220 👎 0
public class Q17 {

    public static void main(String[] args) {
        var q17 = new Q17();
        var answer = q17.letterCombinations("2345");
        System.out.println(answer);
    }

    /**
     * {
     *     2: a  b  c
     *     3: d  e  f
     *     4: g  h  i
     *     5: j  k  l
     *     6: m  n  o
     *     7: p  q  r  s
     *     8: t  u  v
     *     9: w  x  y  z
     * }
     * example:
     *  输入：digits = "23"
     *  输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        if (digits.length() == 1) {
            switch (digits) {
                case "2":
                    return List.of("a", "b", "c");
                case "3":
                    return List.of("d", "e", "f");
                case "4":
                    return List.of("g", "h", "i");
                case "5":
                    return List.of("j", "k", "l");
                case "6":
                    return List.of("m", "n", "o");
                case "7":
                    return List.of("p", "q", "r", "s");
                case "8":
                    return List.of("t", "u", "v");
                case "9":
                    return List.of("w", "x", "y", "z");
                default:
                    return new LinkedList<>();
            }
        } else {
            var subList = letterCombinations(digits.substring(1));
            var enumerate = letterCombinations(digits.substring(0, 1));
            var list = new LinkedList<String>();
            enumerate.forEach(ch -> subList.forEach(sub -> list.add(ch + sub)));
            return list;
        }
    }
}
