/**
 * Created by Jibran on 6/1/19.
 */
public class BubbleSort extends Sort {

    @Override
    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    super.incrementComparisons();
                    swap(arr, j, j+1);
                }
                else {
                    super.incrementComparisons();
                }
            }
        }
    }
}
