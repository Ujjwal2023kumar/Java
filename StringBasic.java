package Strings;
public class StringBasic {
    public static void printLetters(String firstName){
        for(int i =0 ; i< firstName.length(); i++){
            System.out.print(firstName.charAt(i) + " ");
        }
        System.out.println();
    }
    public static boolean isPalindrome(String lastName){
        int n = lastName.length();
        for(int i=0;i< n/2;i++){
            if(lastName.charAt(i) == lastName.charAt(n-1-i)){
                System.out.println(lastName + " is a palindrome.");
                return true;
            }
        }
        System.out.println(lastName + " is not a palindrome.");
        return false;
    }
    public static void getShortestPath(String path){
        int x = 0, y = 0;
        for(int i = 0; i< path.length(); i++){
            char dir = path.charAt(i); 
            if(dir == 'N'){   // North
                y++;
            }
            else if(dir == 'N'){   // South
                y--;
            }
            else if(dir == 'N'){   // East
                x++;
            }
            else if(dir == 'N'){   // West
                x--;
            }
        }
        System.out.println(Math.sqrt((Math.pow((x-0),2) + Math.pow((y-0),2)))); 
    }
    public static void largestString(String fruits[]){
        String largest = fruits[0];

        for(int i= 1; i< fruits.length; i++){
            if(largest.compareToIgnoreCase(fruits[i])<0){
                largest = fruits[i];
            }
        }
        System.out.println(largest + " is the largest string");
    }
    public static void main(String[] args) {
        String firstName = "Shradha", lastName = "madam";
        String path = "WNEENESENNN";
        String fruits[] = {"apple", "mango", "banana"};
        System.out.println(firstName.length());
        System.out.println(firstName + " " + lastName); //concentation
        System.out.println(firstName.charAt(0));
        System.out.println(path.substring(2, 8)); //substring
        printLetters(firstName);
        isPalindrome(lastName);
        getShortestPath(path); 
        largestString(fruits);
    }
}
