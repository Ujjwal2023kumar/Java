import java.util.*;

public class _24Queue {

    static class Queue1{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    static class Stack1{
        static Queue<Integer> q2 = new LinkedList<>();
        static Queue<Integer> q3 = new LinkedList<>();

        public static boolean isEmpty(){
            return q2.isEmpty() && q3.isEmpty();
        }
        public static void push(int data){
            if(!q2.isEmpty()) {
                q2.add(data);
            }else{
                q3.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if(!q2.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q3.add(top);
                }   
            }else{
                while(!q3.isEmpty()){
                    top = q3.remove();
                    if(q3.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = -1;
            if(!q2.isEmpty()){
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q3.add(top);
                }   
            }else{
                while(!q3.isEmpty()){
                    top = q3.remove();
                    q2.add(top);
                }
            }
            return top;
        }
    }
    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) {
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek()+ " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        //Implementation of Queue using JCF
        //Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Implementation of Queue using JCF: ");
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        //Queue using 2 Stacks
        Queue1 q1 = new Queue1();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);

        System.out.println("Implementation of Queue using 2 Stacks: ");
        while(!q1.isEmpty()){
            System.out.println(q1.peek());
            q1.remove();
        }

        //Stack using 2 Queus
        Stack1 s = new Stack1();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("Implementation of Stack using 2 Queues: ");
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        String str = "aabccxb";
        System.out.println("First non-repeating Letter in a stream of characters: ");
        printNonRepeating(str);
    }
}
