package xyz.fe1.algorithms.leetcode.hot100;
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 5922 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q2 {

    public static void main(String[] args) {
        var q2 = new Q2();
        var l1 = q2.getList(9999999);
        var l2 = q2.getList(9999);
        var result = q2.addTwoNumbers(l1, l2);
        q2.printNode(result);
    }

    /**
     * 遍历链表，空缺补0，注意进位问题即可
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var head = new ListNode(0);
        var cursor = head;
        var carry = 0;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }
            cursor.next = new ListNode(val);
            cursor = cursor.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cursor.next = new ListNode(1);
        return head.next;
    }

    private ListNode getList(int val) {
        var head = new ListNode(0);
        var cursor = head;
        for (var c: String.valueOf(val).toCharArray()) {
            cursor.next = new ListNode(Integer.parseInt(c + ""));
            cursor = cursor.next;
        }
        return head.next;
    }

    private void printNode(ListNode head) {
        System.out.print(head.val + " ");
        if (head.next != null) {
            printNode(head.next);
        }
        System.out.print(head.val);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
