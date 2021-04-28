package xyz.fe1.algorithms.leetcode.hot100;

import java.util.LinkedList;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2300 👎 0
public class Q20 {

    public static void main(String[] args) {
        var q20 = new Q20();
        System.out.println(q20.isValid("{}"));
        System.out.println(q20.isValid("{{}]{}"));
        System.out.println(q20.isValid("{{}}"));
        System.out.println(q20.isValid("{}[]()"));
        System.out.println(q20.isValid("(){{[()]}}[]"));
    }

    /**
     * 栈操作即可
     */
    public boolean isValid(String s) {
        var stack = new LinkedList<Character>();
        for (var ch: s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.size() == 0) return false;
                    var pop = stack.pop();
                    if (pop != ch) return false;
            }
        }
        return stack.size() == 0;
    }
}
