package Strings;
public class stringBuilder {
    public static String toUpperCase(String str){
        StringBuilder sb1 = new StringBuilder("");
        
        char ch = Character.toUpperCase(str.charAt(0));
        sb1.append(ch);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb1.append(str.charAt(i));
                i++;
                sb1.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb1.append(str.charAt(i));
            }
        }
        return sb1.toString();
    }
    public static String compress(String str){
        StringBuilder newStr = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(count > 1){
                newStr.append(count);
            }
        }
        return newStr.toString();
    }
    public static void main(String[] args) {
        String str = "aaabbcccdd";
        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch<= 'z'; ch++){
            sb.append(ch);   //abcdefghijklmnopqrstuvwxyz
        }
        System.out.println(sb);
        System.out.println(toUpperCase("hi, my name is ujjwal")); 
        System.out.println(compress(str));
    }
}
