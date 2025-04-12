package LinkedList;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Add to the front
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Add to the end
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Print the linked list
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // Using addLast
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);

        System.out.print("Initial list: ");
        ll.print();

        // Add to the front
        ll.addFirst(0);
        System.out.print("After addFirst(0): ");
        ll.print();

        // Add to the end
        ll.addLast(4);
        System.out.print("After addLast(4): ");
        ll.print();
    }
}
