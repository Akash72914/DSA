class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int n = 1;

        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        k = k % n;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int cnt = n - k - 1;
        ListNode temp = head;

        while (cnt > 0) {
            temp = temp.next;
            cnt--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}