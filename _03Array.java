import java.util.*;
public class _3Array{

    // Function to update all elements in the array by +1
    public static void updateNum(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
        }
    }
    // Function to print the array
    public static void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // Linear Search
    public static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
    // Binary Search (Recursive)
    public static int binarySearch(int arr[], int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) return mid;
        else if (target < arr[mid])
            return binarySearch(arr, low, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, high, target);
    }
    public static int getLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int num : arr)
            if (num > largest) largest = num;
        return largest;
    }
    public static int getSmallest(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        for (int num : arr)
            if (num < smallest) smallest = num;
        return smallest;
    }
    public static void printSearchResult(String type, int index, int target) {
        if (index == -1)
            System.out.println(type + " Search: Target " + target + " not found.");
        else
            System.out.println(type + " Search: Target " + target + " found at index: " + index);
    }
    public static void reverseArr(int arr[]) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void printPairs(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }
    public static void printSubarrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void printMaxSubarrays1(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > maxSum) maxSum = sum;
            }
        }
        System.out.println("Max Subarray Sum (Brute Force): " + maxSum);
    }
    public static void printMaxSubarrays2(int arr[]) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println("Max Subarray Sum (Prefix): " + maxSum);
    }
    public static void printMaxSubarrays3(int arr[]) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for (int value : arr) {
            currSum += value;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) currSum = 0;
        }
        System.out.println("Max Subarray Sum (Kadane's): " + maxSum);
    }
    public static void trappedRainwater(int height[]) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        System.out.println("Trapped Rainwater: " + trappedWater);
    }
    public static void printSpiral(int[][] matrix) {
        int startRow = 0, startCol = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int j = startCol; j <= endCol; j++)
                System.out.print(matrix[startRow][j] + " ");
            for (int i = startRow + 1; i <= endRow; i++)
                System.out.print(matrix[i][endCol] + " ");
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--)
                    System.out.print(matrix[endRow][j] + " ");
            }
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--)
                    System.out.print(matrix[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        System.out.println();
    }
    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }
    public static void staircaseSearch(int[][] matrix, int key) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("Key found at (" + row + "," + col + ")");
                return;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key not found!");
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int arr2[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int height[] = {4, 2, 0, 6, 3, 2, 5};

        System.out.println("Original Array:");
        printArray(arr);

        int linearIndex = linearSearch(arr, 3);
        int binaryIndex = binarySearch(arr, 0, arr.length - 1, 4);

        printSearchResult("Linear", linearIndex, 3);
        printSearchResult("Binary", binaryIndex, 4);

        System.out.println("Largest Number: " + getLargest(arr));
        System.out.println("Smallest Number: " + getSmallest(arr));

        reverseArr(arr);
        System.out.print("Reversed Array: ");
        printArray(arr);

        System.out.println("Array Pairs:");
        printPairs(arr);

        System.out.println("All Subarrays:");
        printSubarrays(arr);

        printMaxSubarrays1(arr2);
        printMaxSubarrays2(arr2);
        printMaxSubarrays3(arr2);

        trappedRainwater(height);

        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        System.out.println("Enter 3x3 matrix elements:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = sc.nextInt();

        System.out.println("Entered Matrix:");
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }

        int matrix2[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printSpiral(matrix2);
        System.out.println("Diagonal Sum: " + diagonalSum(matrix2));

        int matrix3[][] = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        staircaseSearch(matrix3, 33);
        sc.close();
    }
}
