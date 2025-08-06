import java.util.*;

public class _20Stack {

    // Print and empty the stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    // Push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a string using a stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    // Reverse a stack recursively
    public static void reversedStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reversedStack(s);
        pushAtBottom(s, top);
    }

    //Stock Span Problem
    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i= 1; i< stocks.length; i++){
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    //Next Greater Element
    public static void nextGreaterElement1(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[j] > arr1[i]) {
                    arr2[i] = arr1[j];
                    found = true;
                    break; // Found the next greater element
                }
            }
            if (!found) {
                arr2[i] = -1; // No greater element found
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    //Next Greater Element
    public static void nextGreaterElement2(int arr1[], Stack<Integer> s3, int arr3[]){
        for(int i= arr1.length -1; i>=0; i--){
            while(!s3.isEmpty() && arr1[s3.peek()] <= arr1[i]){
                s3.pop();
            }
            if(s3.isEmpty()){
                arr3[i] = -1;
            }else{
                arr3[i] = arr1[s3.peek()];
            }
            s3.push(i);
        }
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    public static void main(String[] args) {
        // Create and modify the first stack
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        pushAtBottom(s1, 4);
        System.out.println("Push bottom of the Stack: ");
        printStack(s1);
    
        // Reverse a string using stack
        String str = "HelloWorld";
        String result = reverseString(str);
        System.out.println("Reverse of "+ str + " is " + result); // Output: dlroWolleH

        // Create a new stack and reverse it
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        reversedStack(s2);
        System.out.println("Reverse of the Stack: ");
        printStack(s2);

        //Stock Span Problem
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);
        for(int i=0; i< span.length; i++){
            System.out.println(span[i] + " ");
        }

        //Next Greater Element
        int arr1[] = {6,8,0,1,3};
        int arr2[] = new int[arr1.length];
        int arr3[] = new int[arr1.length];
        Stack<Integer> s3 = new Stack<>();
        System.out.println("Next Greater Element By Brute Force:");
        nextGreaterElement1(arr1, arr2);
        System.out.println("Next Greater Element(Optimized Approach):");
        nextGreaterElement2(arr1, s3, arr3);
    }
}
