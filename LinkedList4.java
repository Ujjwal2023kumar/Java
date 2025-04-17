package LinkedList;

public class LinkedList4 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;
    public Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        if (head == null) tail = null;
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(rightHead);

        return merge(leftSorted, rightSorted);
    }

    public static void main(String[] args) {
        LinkedList4 ll = new LinkedList4();

        ll.addLast(3);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(2);
        ll.addLast(5);

        System.out.print("Original List: ");
        ll.print();

        ll.head = ll.mergeSort(ll.head);

        System.out.print("Sorted List: ");
        ll.print();
    }
}
