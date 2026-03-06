
// Zig-Zag Linked List

public class ZigZag {
    public static void main(String[] args) {

        LinkedList sll = new LinkedList();

        sll.addNode(1);
        sll.addNode(2);
        sll.addNode(3);
        sll.addNode(4);
        sll.addNode(5);

        System.out.println("Original List:");
        sll.print();

        sll.head = sll.zigZagSll(sll.retHead());

        System.out.println("Zig-Zag List:");
        sll.print();
    }
}

class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    Node retHead() {
        return head;
    }

    // function to add node
    void addNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // reverse Linked List
    Node reverse(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // function for zig-zag SLL
    Node zigZagSll(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Find middle
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split list
        Node second = slow.next;
        slow.next = null;

        // Step 3: Reverse second half
        second = reverse(second);

        // Step 4: Merge alternately
        Node first = head;

        while (first != null && second != null) {

            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

        return head;
    }

    // function to print SLL
    void print() {

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
