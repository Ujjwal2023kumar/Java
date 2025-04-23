import java.util.ArrayList;
import java.util.Collections;

public class ArrayListBasics {
    public static ArrayList<Integer> initializeList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i); // O(1)
        }
        return list;
    }
    public static void performBasicOperations(ArrayList<Integer> list) {
        System.out.println("Initial List: " + list);

        // Get operation (O(1))
        System.out.println("Element at index 3: " + list.get(3));

        // Remove operation (O(n))
        list.remove(2);  
        System.out.println("After removal of element: " + list);

        // Set operation (O(n))
        list.set(2, 3);  
        System.out.println("After setting element: " + list);

        // Add operation (O(n))
        list.add(3, 4);  
        System.out.println("After adding element: " + list);
        System.out.println("Does the list contain 3? " + list.contains(3)); // true
        System.out.println("Does the list contain 4? " + list.contains(4)); // false
        System.out.println("Size of the list: " + list.size());
    }
    public static void printListInReverse() {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list1.add(i);
        }
        System.out.println("List1: " + list1);

        System.out.print("List1 in reverse: ");
        for (int i = list1.size() - 1; i >= 0; i--) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
    }
    public static void findMaximumInList(ArrayList<Integer> list) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            maxNum = Math.max(maxNum, list.get(i));
        }
        System.out.println("Maximum number: " + maxNum);
    }
    public static void swapElementsInList(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        System.out.println("After swapping: " + list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = initializeList(10); 
        performBasicOperations(list);
        findMaximumInList(list);
        swapElementsInList(list, 0, 1);  
        Collections.sort(list);
        System.out.println("Sorted List in ascending Order: " + list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted List in descending Order: " + list);
    }
}
