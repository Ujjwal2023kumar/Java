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
    private int size = 0;

    // Add to the front
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
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
        size++;
    }

    // Add in the Middle
    public void addMid(int data, int index){
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node p = head;
        for(int i = 0; i < index - 1; i++){
            p = p.next;
        }

        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    // Return current size
    public int size(){
        return size;
    }

    // Remove from the front
    public void removeFront(){
        if(head == null){
            System.out.println("No element to remove");
            return;
        }
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }
    }

    // Remove from the end
    public void removeEnd(){
        if(head == null){
            System.out.println("No element to remove");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    // Print the linked list
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
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

        // Add in the middle
        ll.addMid(2, 3);
        System.out.print("After addMid(2, 3): ");
        ll.print();

        // Remove from the front
        ll.removeFront();
        System.out.print("After removeFront(): ");
        ll.print();

        // Remove from the end
        ll.removeEnd();
        System.out.print("After removeEnd(): ");
        ll.print();
    }
}
