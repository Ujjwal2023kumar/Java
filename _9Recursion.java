public class _9Recursion {
    public static int factorial(int n){
        if(n==1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
    public static void printNto1(int n){
        if(n == 1){
            System.out.print(1);
            return;
        }
        System.out.print(n + " ");
        printNto1(n-1);
    }
    
    public static void print1toN(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        print1toN(n-1);
        System.out.print(n + " ");
    }
    public static int sumOfNNatural(int n){
        if(n == 1){
            return 1;
        }else{
            return n + sumOfNNatural(n-1);
        }
    }
    public static int fibonacci(int n){
        if(n==0 || n == 1){
            return n;
        }
        int f1 = fibonacci(n-1); 
        int f2 = fibonacci(n-2);
        return f1+f2;
    }
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOccurence(int arr2[], int key, int i){
        if(i == arr2.length){
            return -1;
        }
        if(arr2[i] == key){
            return i;
        }
        return firstOccurence(arr2, key, i+1);
    }
    public static int lastOccurence(int arr2[], int key, int i){
        if(i == arr2.length){
            return -1;
        }
        int isFound = lastOccurence(arr2, key, i+1);
        if(isFound == -1 && arr2[i] == key){
            return i;
        }
        return isFound;
    }
    public static int xPowN(int x, int n){
        if(n == 1){
            return x;
        }
        return x * xPowN(x, n-1);
    }

    public static int tilingProblem(int n){
        if(n==0 || n==1){ //base
            return 1;
        }
        int fnm1 = tilingProblem(n-1); //vertical choice
        int fnm2 = tilingProblem(n-2); //horizontal choice

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }
    public static void removeDuplicate(String str,int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){ //base
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            // duplicate
            removeDuplicate(str, idx+1, newStr, map);
        }else{
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static int friendsPairing(int n){
        if(n == 1 || n == 2){ //base
            return n;
        }
        int single = friendsPairing(n-1); //single
        int pair = (n-1) * friendsPairing(n-2); //Pairs
        int totalPairWays = single + pair;
        return totalPairWays;
    }
    public static void binaryStrings(int n, int lastPlace, String str1){
        if(n == 0){
            System.out.println(str1);
            return;
        }
        binaryStrings(n-1, 0, str1+"0");
        if(lastPlace == 0){
            binaryStrings(n-1, 1, str1+"1");
        }
    }
    public static void main(String[] args) {
        int n = 10;
        int arr[] = {1,2,3,4,5};
        int arr2[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(factorial(n));
        printNto1(n);
        System.out.println();
        print1toN(n);
        System.out.println();
        System.out.println(sumOfNNatural(n));
        System.out.println(fibonacci(5)); 
        System.out.println(isSorted(arr, 0));
        System.out.println("firstOccurence is " + firstOccurence(arr2, 5, 0));
        System.out.println("lastOccurence is " + lastOccurence(arr2, 5, 0));
        System.out.println("2 raised to power 3 is " + xPowN(2, 3));

        System.out.println(tilingProblem(4));
        String str = "appnnacollege";
        removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(friendsPairing(3));
        binaryStrings(3, 0, "");
    }
}
