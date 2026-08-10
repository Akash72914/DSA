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
    public ListNode sortList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while(temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(arr);

        int i = 0;
        temp = head;

        while(temp != null) {
            temp.val = arr.get(i);
            temp = temp.next;
            i++;
        }

        return head;
    }
}