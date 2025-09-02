import java.util.*;
public class _13Stack{

    // ---------- 1. Stack using LinkedList ----------
    static class LinkedListStack {
        static class Node {
            int data;
            Node next;
            Node(int data) { this.data = data; }
        }
        private Node head = null;

        public boolean isEmpty() { return head == null; }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
    }

    // ---------- 2. Stack using ArrayList ----------
    static class ArrayListStack {
        private ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() { return list.isEmpty(); }

        public void push(int data) { list.add(data); }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return list.remove(list.size() - 1);
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    // ---------- 3. Stack using Java Collections ----------
    // We will use java.util.Stack<Integer> directly.

    // ---------- Utility Methods ----------
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) s.push(c);
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) result.append(s.pop());
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) s.pop();
            span[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }
    }

    public static void nextGreaterElementBrute(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println("Next Greater (Brute): " + Arrays.toString(result));
    }

    public static void nextGreaterElementOptimized(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) s.pop();
            result[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        System.out.println("Next Greater (Optimized): " + Arrays.toString(result));
    }

    public static boolean validParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty()) return false;
                char top = s.peek();
                if ((top == '(' && c == ')') ||
                    (top == '{' && c == '}') ||
                    (top == '[' && c == ']')) {
                    s.pop();
                } else return false;
            }
        }
        return s.isEmpty();
    }

    public static boolean duplicateParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) return true;
                s.pop(); // remove '('
            } else {
                s.push(c);
            }
        }
        return false;
    }

    public static void maxAreaHistogram(int[] hist) {
        int n = hist.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        Stack<Integer> s = new Stack<>();

        // NSR
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) s.pop();
            nsr[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        // NSL
        s.clear();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) s.pop();
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, hist[i] * width);
        }
        System.out.println("Max Histogram Area = " + maxArea);
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        // Test LinkedListStack
        LinkedListStack llStack = new LinkedListStack();
        llStack.push(10);
        llStack.push(20);
        System.out.println("LinkedListStack Peek: " + llStack.peek());
        System.out.println("LinkedListStack Pop: " + llStack.pop());

        // Test ArrayListStack
        ArrayListStack arrStack = new ArrayListStack();
        arrStack.push(100);
        arrStack.push(200);
        System.out.println("ArrayListStack Peek: " + arrStack.peek());
        System.out.println("ArrayListStack Pop: " + arrStack.pop());

        // Test Java Stack with problems
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3);
        reverseStack(s);
        System.out.print("Reversed Stack: ");
        printStack(s);

        // Reverse String
        String str = "HelloWorld";
        System.out.println("Reverse String: " + reverseString(str));

        // Stock Span
        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stocks.length];
        stockSpan(stocks, span);
        System.out.println("Stock Span: " + Arrays.toString(span));

        // Next Greater
        int[] arr = {6, 8, 0, 1, 3};
        nextGreaterElementBrute(arr);
        nextGreaterElementOptimized(arr);

        // Parentheses
        System.out.println("Valid Parentheses '({[]})': " + validParentheses("({[]})"));
        System.out.println("Duplicate Parentheses '((a+b))': " + duplicateParentheses("((a+b))"));

        // Histogram Max Area
        int[] hist = {2, 1, 5, 6, 2, 3};
        maxAreaHistogram(hist);
    }
}
