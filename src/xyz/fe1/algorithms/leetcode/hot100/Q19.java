package xyz.fe1.algorithms.leetcode.hot100;

import xyz.fe1.datastruct.ListNode;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1300 👎 0
public class Q19 {

    public static void main(String[] args) {
        var q19 = new Q19();
        var head = ListNode.getList(1123);
        ListNode.printNode(head);
        head = q19.removeNthFromEnd(head, 1);
        ListNode.printNode(head);
    }

    /**
     * 核心，使用两个指针，间距为N，这样当第一个指针走到链表尾部的时候，第二个指针恰好指向要删除的结点，删除即可
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode current = head, previous = head;
        while (n-- > 0) current = current.next;  // 第一个指针先走到N处
        if (current == null) return previous.next;  // current为NULL表示N等于链表长度，则直接删除第一个结点即可
        while (current.next != null) {  // 两个指针同时向后走
            current = current.next;
            previous = previous.next;
        }
        previous.next = previous.next.next;  // 删除结点
        return head; // 返回头指针
    }
}
