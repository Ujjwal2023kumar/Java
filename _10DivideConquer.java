public class _10DivideConquer {
    public static void printArr(int arr[]){
        for(int i=0; i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
