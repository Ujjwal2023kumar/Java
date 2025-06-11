public class Array {

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
        if (low > high) {
            return -1;  // Base case: Target not found
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;  // Target found
        } else if (target < arr[mid]) {
            return binarySearch(arr, low, mid - 1, target);  // Search left half
        } else {
            return binarySearch(arr, mid + 1, high, target); // Search right half
        }
    }

    // Function to find the largest element
    public static int getLargest(int arr[]) {
        int largestNum = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largestNum) {
                largestNum = num;
            }
        }
        return largestNum;
    }

    // Function to find the smallest element
    public static int getSmallest(int arr[]) {
        int smallestNum = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallestNum) {
                smallestNum = num;
            }
        }
        return smallestNum;
    }

    // Function to print search results
    public static void printSearchResult(String searchType, int index, int target) {
        if (index == -1) {
            System.out.println(searchType + " Search: Target " + target + " not found.");
        } else {
            System.out.println(searchType + " Search: Target " + target + " found at index: " + index);
        }
    }

    // Function to reverse an Array
    public static void reverseArr(int arr[]){
        int first = 0, last = arr.length-1;
        while(first<last){
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;
        }
    }

    //Possible pairs in an array
    public static void printPairs(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    // Function to print Subarrays
    public static void printSubarrays(int arr[]){
        for(int i=0;i<arr.length;i++){
            int start =i;
            for(int j=i;j<arr.length;j++){
                int end=j;
                for(int k= start;k<=end;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Fnction to print max subarray sum
    public static void printMaxSubarrays1(int arr2[]){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<arr2.length;i++){
            int start =i;
            for(int j=i;j<arr2.length;j++){
                int end=j;
                sum = 0;
                for(int k=start;k<=end;k++){
                    sum+= arr2[k];
                }
                if(maxSum<sum){
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }

    // Function to print max subarray sum by Prefix Sum
    public static void printMaxSubarrays2(int arr2[]){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr2.length];

        prefix[0] = arr2[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + arr2[i];
        }
        for(int i=0;i<arr2.length;i++){
            int start =i;
            for(int j=i;j<arr2.length;j++){
                int end=j;
                sum = start== 0? prefix[end] : prefix[end]- prefix[start-1];                
                if(maxSum<sum){
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }

    // Functions to print max subarray sum by Kadanes algorithm
    public static void printMaxSubarrays3(int arr2[]){
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0;i<arr2.length; i++){
            cs += arr2[i];
            maxSum = Math.max(cs, maxSum);
            if(cs<0){
                cs = 0;
            }
        }
        System.out.println(maxSum);
    }

    // Trapping Rainwater Problem
    public static void trappedRainwater(int height[]){
        int n = height.length;
        // calculate left max boundary -array
        int leftMax[] = new int[n];
        leftMax[0]= height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // calculate right max boundary -array
        int rightMax[] = new int[n];
        rightMax[n-1]= height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            //waterLevel = min(leftmax bound, rightmax)
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            // trappedWater = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        System.out.println(trappedWater);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int arr2[] = {-2,-3,4,-1,-2,1,5,-3}; // Used in Max subarray Sum
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("Original Array:");
        printArray(arr);

        // Uncomment this line if you want to modify the array
        // updateNum(arr);

        int targetLinear = 93;
        int targetBinary = 95;

        // Perform searches
        int linearIndex = linearSearch(arr, targetLinear);
        int binaryIndex = binarySearch(arr, 0, arr.length - 1, targetBinary);

        // Print search results
        printSearchResult("Linear", linearIndex, targetLinear);
        printSearchResult("Binary", binaryIndex, targetBinary);

        // Print largest and smallest values
        System.out.println("Largest Number in Array: " + getLargest(arr));
        System.out.println("Smallest Number in Array: " + getSmallest(arr));

        reverseArr(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        printPairs(arr);
        printSubarrays(arr);
        printMaxSubarrays1(arr2); //O(n^3) 3 loop 
        printMaxSubarrays2(arr2); //O(n^2) 2 loop Prefix Sum
        printMaxSubarrays3(arr2); //O(n) 1 loop Kadane's Algorithm
        trappedRainwater(height);
    }
}
