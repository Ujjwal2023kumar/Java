import java.util.*;
public class _07ArrayList {
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

    public static void printNestedArrayList() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            list1.add(i * 1);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println("Nested ArrayList:");
        System.out.println(mainList);
    }

    // 6. Brute Force approach to find container with most water
    public static int maxWaterBruteForce(ArrayList<Integer> container) {
        int maxWater = 0;
        for (int i = 0; i < container.size(); i++) {
            for (int j = i + 1; j < container.size(); j++) {
                int height = Math.min(container.get(i), container.get(j));
                int width = j - i;
                int currWater = height * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    // 7. Optimized 2-pointer approach
    public static int maxWaterTwoPointer(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size() - 1;

        while (lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int wid = rp - lp;
            int currWater = ht * wid;
            maxWater = Math.max(maxWater, currWater);

            // Move the pointer pointing to the shorter line
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }

    // 8. Pair Sum in a sorted list
    public static boolean hasPairWithSum(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    // 9. Pair Sum in a sorted and rotated list
    public static boolean hasPairInSortedRotated(ArrayList<Integer> list, int target) {
        
        int n = list.size();
        int pivot = -1;

        // Find pivot where rotation happened
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }

        int left = (pivot + 1) % n; // smallest element
        int right = pivot;          // largest element

        while (left != right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left = (left + 1) % n;
            } else {
                right = (n + right - 1) % n;
            }
        }

        return false;
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

        // 1. Nested ArrayList
        printNestedArrayList();

        // 2. Container with most water
        ArrayList<Integer> container = new ArrayList<>();
        container.add(1);
        container.add(8);
        container.add(6);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(8);
        container.add(3);
        container.add(7);

        int bruteForceResult = maxWaterBruteForce(container);
        System.out.println("Maximum water stored (Brute Force): " + bruteForceResult);

        int twoPointerResult = maxWaterTwoPointer(container);
        System.out.println("Maximum water stored (2-pointer): " + twoPointerResult);

        // 3. Pair sum in sorted array
        ArrayList<Integer> sortedList = new ArrayList<>();
        sortedList.add(5);
        sortedList.add(6);
        sortedList.add(8);
        sortedList.add(9);
        sortedList.add(10);
        sortedList.add(11);
        int target = 16;
        System.out.println("Pair with sum " + target + " exists in sorted list: " + hasPairWithSum(sortedList, target));

        // 4. Pair sum in sorted & rotated array
        ArrayList<Integer> rotatedList = new ArrayList<>();
        rotatedList.add(11);
        rotatedList.add(15);
        rotatedList.add(6);
        rotatedList.add(8);
        rotatedList.add(9);
        rotatedList.add(10);
        System.out.println("Pair with sum " + target + " exists in rotated list: " + hasPairInSortedRotated(rotatedList, target));
    }
}
    
