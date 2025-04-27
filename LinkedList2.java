public class LinkedList2 {
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

    // Return current size
    public int size(){
        return size;
    }

    // Search iterative
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
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        if(index == -1){
            return -1;
        }
        return index + 1;
    }

    // Reverse the list
    public void reverse(){ // Iterative Approach 
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Find and Remove Nth node from End
    public void removeNthFromEnd(int n){
        if(n == size){
            head = head.next;
            return;
        }
        int i = 1; 
        Node prev = head;
        while(i < size-n){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;
    
        // Step 1: Find middle
        Node slow = head;
        Node fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        // Step 2: Reverse second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    
        // Step 3: Compare both halves
        Node left = head;
        Node right = prev; // Head of reversed half
    
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
    
        return true;
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
        LinkedList2 ll = new LinkedList2();

        // Using addLast
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        System.out.print("Initial list: ");
        ll.print();

        //Find and Remove Nth Node from end
        ll.removeNthFromEnd(2);
        System.out.print("After removeNth(): ");
        ll.print();

        // Print reverse of linked list
        ll.reverse();
        System.out.print("After reverse(): ");
        ll.print();

        // Search iterative
        int key = 2;
        int result = ll.searchIterative(key);
        if (result != -1) {
            System.out.println("Search Iteratively Element " + key + " found at index: " + result);
        } else {
            System.out.println("Search Iteratively Element " + key + " not found in the list.");
        }

        // Search recursive
        int result2 = ll.searchRecursive(key);
        if (result2 != -1) {
            System.out.println("Search Recursively Element " + key + " found at index: " + result2);
        } else {
            System.out.println("Search Recursively Element " + key + " not found in the list.");
        }

        // Final size
        System.out.println("Final size of linked list: " + ll.size());

        // Check if LL is a Palindrome
        System.out.println("The statement LL is palindrome is " + ll.isPalindrome());
    }
}
