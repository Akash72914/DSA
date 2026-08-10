class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two lists
        ListNode right = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        right = sortList(right);

        // Merge sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        if (left != null) {
            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return dummy.next;
    }
}