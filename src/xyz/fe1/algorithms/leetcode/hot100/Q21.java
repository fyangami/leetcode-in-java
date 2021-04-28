package xyz.fe1.algorithms.leetcode.hot100;

import xyz.fe1.datastruct.ListNode;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1635 👎 0
public class Q21 {

    public static void main(String[] args) {
        var q21 = new Q21();
        var l1 = ListNode.getList(124);
        var l2 = ListNode.getList(134);
        ListNode.printNode(q21.mergeTwoLists(l1, l2));
    }

    /**
     * 当有一个链表遍历完成之后可直接结束遍历
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        var head = new ListNode();
        var cursor = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    cursor.next = l2;
                    l2 = l2.next;
                } else {
                    cursor.next = l1;
                    l1 = l1.next;
                }
            } else if (l1 == null) {
                cursor.next = l2;
                break;
            } else {
                cursor.next = l1;
                break;
            }
            cursor = cursor.next;
        }
        return head.next;
    }


}
