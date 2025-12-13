public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //Adding new node at starting of the LL
    public void addFirst(int data) {
        //step1 : create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {          //if the head is empty
            head = tail = newNode;
            return;
        }

        //step2 : newNode's next = head
        newNode.next = head;

        //step3 : head = newNode
        head = newNode;
    }

    //Adding new node in the middle of the LL
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        //i = idx-1;  temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Adding new node at the last of the LL
    public void addLast(int data) {
        //step1 : create a new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {          //if the tail is empty
            head = tail = newNode;
            return;
        }

        //step2 : tail's next = new node
        tail.next = newNode;

        //step3 : tail = newNode
        tail = newNode;
    }

    //Removing a node from the start of the LL
    public int removeFirst() {
        if(size == 0 || head == null) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Removing a node from the last of the LL
    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev : i = size-2
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    //Removing nth node from end of the LL
    public void deleteNthfromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next;
            return;
        }

        //sz - n
        int i = 0;
        int iToFind = sz - n - 1;
        Node prev = head;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    //Searching in the LL (iterative)
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null) {
            if(temp.data == key) {
                return i;
            } else {
                temp = temp.next;
                i++;
            }
        }

        return -1;
    }

    //Searching in the LL (recursive)
    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }

        return idx + 1;
    }
    public int recSearch(int key) {
        return helper(head, key);
    }

    //Reverse of the LL
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    //Finding Middle of the LL
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;        //+1
            fast = fast.next.next;   //+2
        }

        return slow;   //slow is the midNode
    }

    //Checking is the LL palindrome or not
    public boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        //step1 - find mid
        Node miNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = miNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;  //right half head
        Node left = head;

        //step3 - check left half = right half
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    //Cycle / Loop in a LL
    public boolean cycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;    //cycle exist
            }
        }

        return false;   //cycle doesn't exist
    }

    //Remove cycle from a LL
    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }

        //find meeting point 
        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> prev.next(lastNode) = null
        prev.next = null;
    }

    //Printing LL
    public void printList() {
        Node temp = head;

        if(temp == null) {
            System.out.println("Linked List is empty");
            return;
        }

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        //ll.addFirst(2);
        //ll.addFirst(1);
        //ll.addLast(1);
        //ll.addLast(2);
        //ll.addLast(3);
        //ll.addLast(4);
        //ll.add(2, 9);

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);   //1->2->3
        head.next.next.next = temp;;          //1->2->3->1

        //ll.removeFirst();
        //ll.removeLast();
        //ll.deleteNthfromEnd(3);

        //ll.reverse();
        //ll.printList();

        //System.out.println(ll.itrSearch(3));
        //System.out.println(ll.itrSearch(10));

        //System.out.println(ll.recSearch(3));

        //System.out.println(ll.checkPalindrome());

        System.out.println(ll.cycle());
        removeCycle();
        System.out.println(ll.cycle());

        //System.out.println(ll.size);
    }
}
