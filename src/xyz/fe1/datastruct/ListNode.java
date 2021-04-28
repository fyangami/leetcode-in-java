package xyz.fe1.datastruct;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printNode(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        if (head.next != null) {
            printNode(head.next);
        } else {
            System.out.println();
        }
    }

    public static ListNode getList(int val) {
        return getList(String.valueOf(val));
    }

    public static ListNode getList(String val) {
        ListNode cursor = null, head = null;
        int i;
        for (i = 0; i < val.length(); ++i) {
            var node = new ListNode(Integer.parseInt(val.substring(i, i + 1)));
            if (head == null) {
                head = node;
                cursor = head;
            } else {
                cursor.next = node;
                cursor = cursor.next;
            }
        }
        return head;
    }
}
