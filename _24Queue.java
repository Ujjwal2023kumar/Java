import java.util.*;

public class _24Queue {

    static class Queue1 {
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

    static class Stack1 {
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();

        public boolean isEmpty() {
            return q2.isEmpty() && q3.isEmpty();
        }

        public void push(int data) {
            if (!q2.isEmpty()) {
                q2.add(data);
            } else {
                q3.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if (!q2.isEmpty()) {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q3.add(top);
                }
            } else {
                while (!q3.isEmpty()) {
                    top = q3.remove();
                    if (q3.isEmpty()) {
                        break;
                    }
                    q2.add(top);
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
            if (!q2.isEmpty()) {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q3.add(top);
                }
            } else {
                while (!q3.isEmpty()) {
                    top = q3.remove();
                    q2.add(top);
                }
            }
            return top;
        }
    }

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

    public static void interleave(Queue<Integer> q4) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q4.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q4.remove());
        }

        while (!firstHalf.isEmpty()) {
            q4.add(firstHalf.remove());
            q4.add(q4.remove());
        }
    }

    public static void queueReversal(Queue<Integer> q4) {
        Stack<Integer> s = new Stack<>();
        while (!q4.isEmpty()) {
            s.push(q4.remove());
        }
        while (!s.isEmpty()) {
            q4.add(s.pop());
        }
    }

    static class Stack2 {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            if (dq.isEmpty()) {
                System.out.println("Stack2 is empty");
                return -1;
            }
            return dq.removeLast();
        }

        public int peek() {
            if (dq.isEmpty()) {
                System.out.println("Stack2 is empty");
                return -1;
            }
            return dq.getLast();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }
    }

    static class Queue2 {
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            if (dq.isEmpty()) {
                System.out.println("Queue2 is empty");
                return -1;
            }
            return dq.removeFirst();
        }

        public int peek() {
            if (dq.isEmpty()) {
                System.out.println("Queue2 is empty");
                return -1;
            }
            return dq.getFirst();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }
    }

    public static void main(String[] args) {

        // Implementation of Queue using JCF
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.print("Implementation of Queue using JCF: ");
        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        System.out.println();

        // Queue using 2 Stacks
        Queue1 q1 = new Queue1();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        System.out.print("Implementation of Queue using 2 Stacks: ");
        while (!q1.isEmpty()) {
            System.out.print(q1.peek() + " ");
            q1.remove();
        }
        System.out.println();

        // Stack using 2 Queues
        Stack1 s = new Stack1();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.print("Implementation of Stack using 2 Queues: ");
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();

        // First non-repeating Letter in a stream of characters
        String str = "aabccxb";
        System.out.print("First non-repeating Letter in a stream of characters: ");
        printNonRepeating(str);

        // Interleave two halves of a Queue
        Queue<Integer> q4 = new LinkedList<>();
        q4.add(1);
        q4.add(2);
        q4.add(3);
        q4.add(4);
        q4.add(5);
        q4.add(6);
        q4.add(7);
        q4.add(8);
        q4.add(9);
        q4.add(10);

        interleave(q4);
        System.out.print("Interleave two halves of a Queue: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(q4.remove() + " ");
        }
        System.out.println();

        // Reset q4 for reversal test
        q4.add(1);
        q4.add(2);
        q4.add(3);
        q4.add(4);
        q4.add(5);

        // Queue Reversal
        queueReversal(q4);
        System.out.print("Queue Reversal: ");
        while (!q4.isEmpty()) {
            System.out.print(q4.remove() + " ");
        }
        System.out.println();

        // Implementation of Deque
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(3); // 3
        dq.addLast(4); // 3 4
        dq.addFirst(2); // 2 3 4
        dq.addFirst(1); // 1 2 3 4
        System.out.println("Addition in Deque: " + dq);

        dq.removeLast(); // 1 2 3
        dq.removeFirst(); // 2 3
        System.out.println("Deletion in Deque: " + dq);

        // Implementation of Stack using Deque
        Stack2 s2 = new Stack2();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        s2.push(4);
        s2.push(5);
        System.out.print("Implementation of Stack using Deque: ");
        while (!s2.isEmpty()) {
            System.out.print(s2.peek() + " ");
            s2.pop();
        }
        System.out.println();

        // Implementation of Queue using Deque
        Queue2 q5 = new Queue2();
        q5.add(1);
        q5.add(2);
        q5.add(3);
        q5.add(4);
        q5.add(5);
        System.out.print("Implementation of Queue using Deque: ");
        while (!q5.isEmpty()) {
            System.out.print(q5.peek() + " ");
            q5.remove();
        }
        System.out.println();
    }
}
