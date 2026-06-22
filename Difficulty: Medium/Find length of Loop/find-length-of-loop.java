/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();
        int cnt = 0;
        
        while(temp != null) {
            if(map.containsKey(temp)) {
                Node startOfLoop = temp;
                
                do{
                    cnt++;
                    temp = temp.next;
                } while(temp != startOfLoop);
                
                return cnt;
            }
            
            map.put(temp, 1);
            temp = temp.next;
        }
        
        return 0;
    }
}