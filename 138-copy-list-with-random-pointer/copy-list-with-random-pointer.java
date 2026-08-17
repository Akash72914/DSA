class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null) {

            Node copyNode = new Node(temp.val);

            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = temp.next.next;
        }

        temp = head;

        while (temp != null) {

            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        temp = head;
        Node copyHead = head.next;

        while (temp != null) {

            Node copyNode = temp.next;

            temp.next = copyNode.next;

            if (copyNode.next != null) {
                copyNode.next = copyNode.next.next;
            }

            temp = temp.next;
        }

        return copyHead;
    }
}