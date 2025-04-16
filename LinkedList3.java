package LinkedList;

public class LinkedList3 {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    private int size = 0;

    // Add to the end, and return the new node
    public Node addLast(int data){
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    // Return current size
    public int size(){
        return size;
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

    // Detect if loop exists using Floyd's cycle detection
    public Boolean isLoop(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    // Remove loop if it exists
    public void removeLoop(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // Detect loop
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(!cycle) return;

        // Reset slow to head
        slow = head;

        // Special case: loop starts at head
        if(slow == fast) {
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }

        // Find the node just before the start of the loop
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove loop
        prev.next = null;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        LinkedList3 ll = new LinkedList3();

        ll.addLast(1);
        Node temp = ll.addLast(2);     // Save reference to node with value 2
        ll.addLast(3);
        ll.addLast(4);
        Node last = ll.addLast(5);     // Save reference to node with value 5

        last.next = temp;              // Create loop: 5 -> 2

        System.out.println("Before removing loop:");
        System.out.println("Loop present? " + ll.isLoop());

        ll.removeLoop();

        System.out.println("After removing loop:");
        System.out.println("Loop present? " + ll.isLoop());

        System.out.print("List: ");
        ll.print();  // Should now print 1->2->3->4->5->null
    }
}
