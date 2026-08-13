/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0;     //length of list 1
        int n2 = 0;     //length of list 2

        while(temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        temp1 = headA;
        temp2 = headB;

        if(n1 > n2) {
            int d = n1 - n2;

            while(d != 0) {
                temp1 = temp1.next;
                d--;
            }
        } else {
            int d = n2 - n1;

            while(d != 0) {
                temp2 = temp2.next;
                d--;
            }
        }
        
        while(temp1 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }
}