/**
 * Created by Jibran on 6/1/19.
 */
public class QuickSort extends Sort {

    /**
     * Partition's the array for 2 indexes
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If cur element is smaller than / equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i, j);
                super.incrementComparisons();
            }
            else {
                super.incrementComparisons();
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i+1, high);

        return i + 1;
    }


    /**
     * Sorts the array using partition method.
     * @param arr
     * @param low
     * @param high
     */
    @Override
    public void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            super.incrementComparisons();
            // pi is partitioning index, arr[pi] is
             // now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);

        }
    }
}
