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
        ListNode temp = head;
        int n = 1;

        while(temp.next != null) {
            n++;
            temp = temp.next;
        }

        if(n == 1) {
            return null;
        }

        temp = head;

        for(int i=1; i<n/2; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}