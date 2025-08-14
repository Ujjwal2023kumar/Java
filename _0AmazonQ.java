//import java.util.*;
public class _0AmazonQ {

    //Function to remove duplicates from sorted array
    public static int removeDuplicates(int arr[]){
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i] < arr[j]){
                int temp = arr[i+1];
                arr[i+1] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        return i+1;
    }
    //Function to merge sorted array
    //Function to Pascal's triangle
    //Function to find missing number
    //Function to merge two sorted lissts
    //Function to intersection of two Linked Lists
    //Function to palindromic Linked List
    //Function to Last Stone Weight

    public static void main(String[] args) {

        System.out.print("Removing Duplicates from Sorted Array: ");
        int arr[] = {0,1,1,1,2,2,3};
        System.out.print(removeDuplicates(arr));
        System.out.println();


        System.out.print("Merge Sorted Array: ");
        System.out.println();


        System.out.print("Pascal's Triangle");
        System.out.println();


        System.out.print("Missing Number: ");
        System.out.println();


        System.out.print("Merge Two Sorted Lists: ");
        System.out.println();


        System.out.print("Intersection of Two Linked Lists: ");
        System.out.println();


        System.out.print("Palindromic Linked List: ");
        System.out.println();


        System.out.print("Last Stone Weight: ");
        System.out.println();
    }
}
