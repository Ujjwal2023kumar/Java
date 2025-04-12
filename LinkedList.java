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

    // Add in the Middle
    public void addMid(int data, int index){
        Node p = head;
        Node newNode = new Node(data);
        for(int i =0; i<index; i++){
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
        newNode.data = data;
    }

    //Size of linked list 
    public int size(){
        Node temp = head;
        int count = 0;
        while(temp!= null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //Remove from the front
    public void removeFront(){
        if(head == null){
            System.out.println("No element to remove");
            return;
        }
        head = head.next;
        return;
    }

    //Remove from the end
    public void removeEnd(){
        if(head == null){
            System.out.println("No element to remove");
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp; 
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

    //Search interative
    public int searchIterative(int key){
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1; // Not found
    }
    
    // Wrapper method for searchRecursive
    public int searchRecursive(int key) {
        return helper(head, key);
    }

    // Actual recursive helper
    public int helper(Node head, int key) {
        if (head == null) {
            return 0; // Reached end without finding
        }
        if (head.data == key) {
            return 0; // Found the target
        }
        int index = helper(head.next, key);
        if(index == -1){
            return -1;
        }
        return index+1;
    }

    public void printReverse(){ //Iterative Approach 
        
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

        //Add in the middle
        ll.addMid(2,3);
        System.out.print("After addMin(2,2): ");
        ll.print();

        //Size of linked list
        System.out.println("Size of linked list: " + ll.size());

        //remove from the front
        ll.removeFront();
        System.out.print("After removeFront(): ");
        ll.print();

        //remove from the end
        ll.removeEnd();
        System.out.print("After removeEnd(): ");
        ll.print();

        //search iterative
        int key = 2;
        int result = ll.searchIterative(key);
        if (result != -1) {
            System.out.println("Element " + key + " found at index: " + result);
        } else {
            System.out.println("Element " + key + " not found in the list.");
        }

        //search recursive
        int result2 = ll.searchIterative(key);
        if (result2 != -1) {
            System.out.println("Element " + key + " found at index: " + result2);
        } else {
            System.out.println("Element " + key + " not found in the list.");
        }

        //Print reverse of linked list
    }
}
