import java.util.Stack;

public class _21Stack {

    public static boolean validParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i=0; i< str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);  // Push opening brackets onto the stack
            } else {
                if (s.isEmpty()) {
                    return false;  // No matching opening bracket
                }
                if ((s.peek() == '(' && c == ')') ||
                    (s.peek() == '{' && c == '}') ||
                    (s.peek() == '[' && c == ']')) {
                        s.pop(); 
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean duplicateParentheses(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')'){
                int count = 0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int hist[]) {
        int maxArea = 0;
        int nsr[] = new int[hist.length];
        int nsl[] = new int[hist.length];

        // Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for (int i = hist.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
                s.pop();
            }
            nsr[i] = s.isEmpty() ? hist.length : s.peek();
            s.push(i);
        }

        // Next Smaller Left
        s = new Stack<>();
        for (int i = 0; i < hist.length; i++) {
            while (!s.isEmpty() && hist[s.peek()] >= hist[i]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        // Compute max area
        for (int i = 0; i < hist.length; i++) {
            int height = hist[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Maximum Area in Histogram is " + maxArea);
    }

    public static void main(String[] args) {

        //Valid Parentheses
        String str1 = "(){}[]";
        String str2 = "()";
        String str3 = "({[()]})";
        String str4 = "([)]";
        System.out.println("Is Parentheses Valid: ");
        System.out.println(validParentheses(str1));
        System.out.println(validParentheses(str2)); 
        System.out.println(validParentheses(str3)); 
        System.out.println(validParentheses(str4)); 

        //Duplicate Parentheses
        String str5 = "((a+b))";
        String str6 = "(a-b)";
        System.out.println("Is Parentheses Duplicate: ");
        System.out.println(duplicateParentheses(str5));
        System.out.println(duplicateParentheses(str6));

        //Maximum Area in Histogram
        int hist[] = {2,1,5,6,2,3}; 
        maxArea(hist);
    }
}
