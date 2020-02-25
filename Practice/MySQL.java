/**
 * Created by Jibran on 5/28/19.
 */
public class MySQL {
    public static void main(String[] args) {

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }



    public static void recursiveBubble(int[] arr, int size) {
        // Base case
        if (size == 1) {
            return;
        }

        size = arr.length;
        for (int i = 0; i < size-1; i++)
            if (arr[i] > arr[i+1])
            {
                // swap arr[i], arr[i+1]
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

        // Largest element is fixed,
        // recur for remaining array
        recursiveBubble(arr, size-1);
    }

    /*
        Pick an element (pivot). Sort the array so that the smaller values go on the left and
        the larger values go on the right. There are over 10+ different implementations of this.
     */


    public static void quickSort() {

    }
}
