/**
 * Created by Jibran on 4/25/19.
 */
public class QueueInt {
    private int[] array = new int[100]; // initial array size

    /**
     * Puts whatever value you input into the queue. Operates on a FIFO basis.
     * @param value
     */
    public void enqueue(int value) {
        int[] newArr; // this gets used if the the array becomes full.
        boolean check = false; // checks to see if array is full

        for(int i = 0; i < array.length; i++) {
            if(array[i] == 0) {     // if the array is empty, then store the value passed into the array.
                                    // from there, set check equal to true, meaning that the array still has
                                    // space to store more variables; after that break out of the loop.
                array[i] = value;
                check = true;
                break;
            }
        }

        if(!(check)) { // if the check is false, meaning if the array is full, then initialize the newArr
                       // to double the size of the array.
            newArr = new int[array.length * 2];
            for(int i = 0; i < array.length; i++) {
                newArr[i] = array[i];   // this copies over all the values from the original array to the new array
            }
            for(int i = 0; i < newArr.length; i++) { // once that's done, then we add our value to the slot in the array
                if(newArr[i] == 0) {
                    newArr[i] = value;
                    array = newArr;
                    return;
                }
            }
        }
    }

    /**
     * Removes the first value it can see in the queue. Operates on a FIFO basis.
     * @return
     */
    public int dequeue() {
        int temp = 0; // creates a temporary integer value which will be returned.
                      // this variable will be the value that you remove from the array

        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) { // opposite of enqueue, where if the array is not empty, then we
                                // set the value of temp to that slot in the array so we can return it,
                                // and then set the element in that slot of the array to 0.
                temp = array[i];
                array[i] = 0;
                return temp;
            }
        }
        return temp; // we return 0 if there was nothing originally in the the array.
    }

    /**
     * This method returns true or false based on whether or not the array is empty.
     * @return
     */
    public boolean isEmpty() {
        for(int i = 0; i < this.array.length; i++) { // if the value at that index in the array is not 0, then return
                                                     // false, if it was empty it would go all the way to the end
                                                     // of the array, and once it exits the for loop and there were no
                                                     // elements to be found, it returns true that the array is empty.
            if(array[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // test method
    /*public void report() {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }*/
}
