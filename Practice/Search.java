/**
 * Created by Jibran on 5/14/19.
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 9;
        arr[3] = 4;

        System.out.println(LinearSearch(arr, 0, 0));
        System.out.println(binarySearch(arr, 9));
    }

    public static int LinearSearch(int[] array, int x, int index) {
        if(index >= array.length) {
            return -1;
        }
        if(array[index] == x) {
            return index;
        }
        return LinearSearch(array, x, index+1);
    }

    public static int binarySearch(int arr[], int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            else if(x < arr[mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] arr, int target, int start, int end) {
        if (start > end)
        {
            // target was not found
            return -1;
        }

        int mid = (start + end) / 2;
        if (target == arr[mid])
        {
            return mid;
        }
        else if (target < arr[mid])
        {
            // search the left half
            return binarySearchRec(arr, target, start, mid - 1);
        }
        else
        {
            // search the right half
            return binarySearchRec(arr, target, mid + 1, end);
        }
    }
}
