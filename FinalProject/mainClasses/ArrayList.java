package mainClasses;
import java.util.*;

public class ArrayList<T extends Comparable> {
	private Object[] array = new Object[2];

	/**
	 * Empty constructor
	 */
	public ArrayList() {

	}

	/**
	 * Add method to add Object into the list.
	 * @param in
	 */
	public void add(T in) {
		// Follows the same principle almost of QueueInt

		Object[] newArr;
		boolean check = false;

		for(int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = in;
				check = true;
				break;
			}
		}

		if(!(check)) { // if the check is false, meaning if the array is full, then initialize the newArr
			// to double the size of the array.
			newArr = new Object[array.length + 1];
			for(int i = 0; i < array.length; i++) {
				newArr[i] = array[i];   // this copies over all the values from the original array to the new array
			}
			for(int i = 0; i < newArr.length; i++) { // once that's done, then we add our value to the slot in the array
				if(newArr[i] == null) {
					newArr[i] = in;
					array = newArr;
					return;
				}
			}
		}
    }

	/**
	 * Removes object from that index and shifts the array left.
	 * @param index
	 * @return
	 * @throws PizzaException
	 */
    public T remove(int index) throws PizzaException {
		Object temp = array[index]; // assigning temp to whichever index's element we will remove
		array[index] = null;
		for(int i = index; i < array.length; i++) {
			if (i+1 == array.length) { // Accounting for ArrayIndexOutOfBounds
				break;
			}
			array[i] = array[i+1]; // shifting everything to the left
		}
		array[array.length - 1] = null; // Setting last element to null as everything's been shifted left.
		return (T)temp; // return the value we removed.

	}

	/**
	 * Size of the array.
	 * @return
	 */
	public int size() {
		return array.length;
	}

	/**
	 * Boolean return statement if array is empty or not.
	 * @return
	 */
	public boolean isEmpty() {
		for(int i = 0; i < array.length; i++) {
			if (array[i] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Swaps 2 indexes in the array.
	 * @param idx1
	 * @param idx2
	 */
	public void swap(int idx1, int idx2) {
		T temp = (T) array[idx1]; // Casting (T) to the element at the array index, temp is assigned to value that'll get
								// swapped
		array[idx1] = array[idx2]; // swap happens
		array[idx2] = temp;
	}

	/**
	 * Getter for the element at the index of the array
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return (T)array[index];
	}

	/**
	 * Returns a string of what's in the array list.
	 * @return
	 */
	@Override
	public String toString() {
		String t = "";
		System.out.println("Here's the array list currently: ");
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				t += array[i] + "\n";
			}
		}

		return t;
	}

	/**
	 * Main to test ArrayList class methods.
	 * @param args
	 */
	/*public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		System.out.println(list);
		System.out.println(list.remove(1));
		System.out.println(list);
	}*/
	// get, remove, size, isEmpty
	
}
