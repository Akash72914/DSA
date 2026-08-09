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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(fast.next == null) {
            return null;
        }

        while(fast != null && fast.next !=null) {
            if(fast == head) {
                fast = fast.next.next;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        slow.next = slow.next.next;

        return head;
    }
}