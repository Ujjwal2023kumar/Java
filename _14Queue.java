import java.util.*;

public class _14Queue{

    // ---------------- Queue using Array ----------------
    static class QueueArray {
        int arr[];
        int size;
        int rear;

        QueueArray(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    // ---------------- Circular Queue using Array ----------------
    static class CircularQueue {
        int arr[];
        int size;
        int front = -1;
        int rear = -1;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    // ---------------- Queue using Linked List ----------------
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLinkedList {
        private Node head = null;
        private Node tail = null;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    // ---------------- Queue using 2 Stacks ----------------
    static class QueueUsingStacks {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    // ---------------- Stack using 2 Queues ----------------
    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) break;
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    // ---------------- First Non-Repeating Character ----------------
    public static void printNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    // ---------------- Interleave Two Halves of Queue ----------------
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // ---------------- Queue Reversal ----------------
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // ---------------- Stack using Deque ----------------
    static class StackUsingDeque {
        Deque<Integer> dq = new LinkedList<>();
        public void push(int data) { dq.addLast(data); }
        public int pop() { return dq.isEmpty() ? -1 : dq.removeLast(); }
        public int peek() { return dq.isEmpty() ? -1 : dq.getLast(); }
        public boolean isEmpty() { return dq.isEmpty(); }
    }

    // ---------------- Queue using Deque ----------------
    static class QueueUsingDeque {
        Deque<Integer> dq = new LinkedList<>();
        public void add(int data) { dq.addLast(data); }
        public int remove() { return dq.isEmpty() ? -1 : dq.removeFirst(); }
        public int peek() { return dq.isEmpty() ? -1 : dq.getFirst(); }
        public boolean isEmpty() { return dq.isEmpty(); }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        // Queue using Array
        QueueArray qa = new QueueArray(5);
        qa.add(1); qa.add(2); qa.add(3); qa.add(4); qa.add(5);
        System.out.print("Queue using Array: ");
        while (!qa.isEmpty()) { System.out.print(qa.peek() + " "); qa.remove(); }
        System.out.println();

        // Circular Queue
        CircularQueue cq = new CircularQueue(5);
        cq.add(1); cq.add(2); cq.add(3); cq.add(4); cq.add(5);
        System.out.print("Circular Queue: ");
        while (!cq.isEmpty()) { System.out.print(cq.peek() + " "); cq.remove(); }
        System.out.println();

        // Queue using Linked List
        QueueLinkedList ql = new QueueLinkedList();
        ql.add(1); ql.add(2); ql.add(3); ql.add(4); ql.add(5);
        System.out.print("Queue using LinkedList: ");
        while (!ql.isEmpty()) { System.out.print(ql.peek() + " "); ql.remove(); }
        System.out.println();

        // Queue using 2 Stacks
        QueueUsingStacks q2s = new QueueUsingStacks();
        q2s.add(1); q2s.add(2); q2s.add(3); q2s.add(4); q2s.add(5);
        System.out.print("Queue using 2 Stacks: ");
        while (!q2s.isEmpty()) { System.out.print(q2s.peek() + " "); q2s.remove(); }
        System.out.println();

        // Stack using 2 Queues
        StackUsingQueues s2q = new StackUsingQueues();
        s2q.push(1); s2q.push(2); s2q.push(3); s2q.push(4); s2q.push(5);
        System.out.print("Stack using 2 Queues: ");
        while (!s2q.isEmpty()) { System.out.print(s2q.peek() + " "); s2q.pop(); }
        System.out.println();

        // First Non-Repeating Character
        System.out.print("First non-repeating chars: ");
        printNonRepeating("aabccxb");

        // Interleave Queue
        Queue<Integer> q = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        interleave(q);
        System.out.print("Interleaved Queue: ");
        while (!q.isEmpty()) System.out.print(q.remove() + " ");
        System.out.println();

        // Queue Reversal
        Queue<Integer> qrev = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        queueReversal(qrev);
        System.out.print("Reversed Queue: ");
        while (!qrev.isEmpty()) System.out.print(qrev.remove() + " ");
        System.out.println();

        // Stack using Deque
        StackUsingDeque sd = new StackUsingDeque();
        sd.push(1); sd.push(2); sd.push(3); sd.push(4); sd.push(5);
        System.out.print("Stack using Deque: ");
        while (!sd.isEmpty()) { System.out.print(sd.peek() + " "); sd.pop(); }
        System.out.println();

        // Queue using Deque
        QueueUsingDeque qd = new QueueUsingDeque();
        qd.add(1); qd.add(2); qd.add(3); qd.add(4); qd.add(5);
        System.out.print("Queue using Deque: ");
        while (!qd.isEmpty()) { System.out.print(qd.peek() + " "); qd.remove(); }
        System.out.println();
    }
}
