import java.util.*;
public class _04Sorting {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        } 
    }
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min]> arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int arr[]){
        for(int i=1; i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            // finding out the correct position to insert
            while(prev >=0 && arr[prev]> curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            // Insertion
            arr[prev+1] = curr;
        }
    }
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest  = Math.max(largest,arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i=0; i<arr.length;i++){
            count[arr[i]]++;
        }

        int j = 0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[j]= i;
                j++;
                count[i]--;
            }
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid+1, ei); // right part
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int n1 = mid - si + 1;
        int n2 = ei - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
    
        System.arraycopy(arr, si, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);
    
        int i = 0, j = 0, k = si;
        while (i < n1 && j < n2) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        Integer arr2[] = {5,4,1,3,2};
        bubbleSort(arr);
        printArr(arr);
        selectionSort(arr);
        printArr(arr);
        insertionSort(arr);
        printArr(arr);
        countingSort(arr);
        printArr(arr);
        Arrays.sort(arr); 
        printArr(arr);
        // to get in reverse order
        Arrays.sort(arr2, Collections.reverseOrder());
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
