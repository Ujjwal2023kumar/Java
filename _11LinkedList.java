public class _11LinkedList {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    // ---------- Add ----------
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addMid(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) { addFirst(data); return; }
        if (index == size) { addLast(data); return; }
        Node p = head;
        for (int i = 0; i < index - 1; i++) p = p.next;
        Node newNode = new Node(data);
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    // ---------- Remove ----------
    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        size--;
        if (head == null) tail = null;
    }

    public void removeLast() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) temp = temp.next;
            temp.next = null;
            tail = temp;
        }
        size--;
    }

    public void removeNthFromEnd(int n) {
        if (n <= 0 || n > size) return;
        if (n == size) {
            head = head.next;
            size--;
            return;
        }
        Node prev = head;
        for (int i = 1; i < size - n; i++) prev = prev.next;
        prev.next = prev.next.next;
        size--;
    }

    // ---------- Search ----------
    public int searchIterative(int key) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == key) return index;
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int searchRecursive(int key) {
        return searchRecursiveHelper(head, key);
    }

    private int searchRecursiveHelper(Node node, int key) {
        if (node == null) return -1;
        if (node.data == key) return 0;
        int idx = searchRecursiveHelper(node.next, key);
        return (idx == -1) ? -1 : idx + 1;
    }

    // ---------- Reverse ----------
    public void reverse() {
        Node prev = null;
        Node curr = head;
        tail = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // ---------- Palindrome ----------
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, curr = slow;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head, right = prev;
        while (right != null) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // ---------- Loop Detection & Removal ----------
    public boolean isLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public void removeLoop() {
        Node slow = head, fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { cycle = true; break; }
        }
        if (!cycle) return;

        slow = head;
        if (slow == fast) {
            while (fast.next != slow) fast = fast.next;
            fast.next = null;
            return;
        }

        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // ---------- Merge Sort ----------
    private Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node h1, Node h2) {
        Node dummy = new Node(-1), temp = dummy;
        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) { temp.next = h1; h1 = h1.next; }
            else { temp.next = h2; h2 = h2.next; }
            temp = temp.next;
        }
        if (h1 != null) temp.next = h1;
        if (h2 != null) temp.next = h2;
        return dummy.next;
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

    public void sort() {
        head = mergeSort(head);
        Node temp = head;
        while (temp != null && temp.next != null) temp = temp.next;
        tail = temp;
    }

    // ---------- Utility ----------
    public int size() { return size; }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ---------- Main (Testing) ----------
    public static void main(String[] args) {
        _11LinkedList ll = new _11LinkedList();

        ll.addLast(3);
        ll.addLast(1);
        ll.addLast(4);
        ll.addLast(2);
        ll.addLast(5);

        System.out.print("Original List: ");
        ll.print();

        ll.sort();
        System.out.print("Sorted List: ");
        ll.print();

        ll.reverse();
        System.out.print("Reversed List: ");
        ll.print();

        System.out.println("Search 4 (Iterative): " + ll.searchIterative(4));
        System.out.println("Search 4 (Recursive): " + ll.searchRecursive(4));

        System.out.println("Is Palindrome? " + ll.isPalindrome());

        ll.removeNthFromEnd(2);
        System.out.print("After removing 2nd from end: ");
        ll.print();

        Node second = ll.head.next;
        ll.tail.next = second;
        System.out.println("Loop present? " + ll.isLoop());
        ll.removeLoop();
        System.out.println("Loop present after removal? " + ll.isLoop());

        System.out.print("Final List: ");
        ll.print();
    }
}
