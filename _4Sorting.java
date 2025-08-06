import java.util.*;
public class _4Sorting {
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
        // We can use inbuilt sort Arrays.sort(arr, si, ei) 
        Arrays.sort(arr); //O(n log n)
        printArr(arr);
        // to get in reverse order
        Arrays.sort(arr2, Collections.reverseOrder());
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }
}
