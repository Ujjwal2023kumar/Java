package Recursion;

public class Recursion2 {
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
        System.out.println(tilingProblem(4));
        String str = "appnnacollege";
        removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        System.out.println(friendsPairing(3));
        binaryStrings(3, 0, "");
    }
}
