public class QuickSort {

    // Time -> O(n * log(n)) //
    // Space -> O(log(n)) //

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}
