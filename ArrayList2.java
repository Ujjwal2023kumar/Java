import java.util.ArrayList;
public class ArrayList2 {

    // 1. Print nested ArrayList
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

    // 2. Brute Force approach to find container with most water
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

    // 3. Optimized 2-pointer approach
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

    // 4. Pair Sum in a sorted list
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

    // 5. Pair Sum in a sorted and rotated list
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
