import java.util.Arrays;
/*
 * Sort Class - abstract parent class which defines the minimum requirements
 * to be a sort.  Subclasses must inherit from and implement the abstract methods below. 
 * Look in the main driver for example usage for your sorts.  Start by building a 
 * Bubble Sort, and comment out other Quick Sort code below to test your
 * first sort class independently before moving on to the more complex
 * Quick Sort subclass.
 * 
 * Author: Rob Nash
 * 
 */

public abstract class Sort {

	//TODO: you override this method with a concrete (ie, not abstract) sort mechanism

	public void sort(int[] data, int first, int last) {
	}  //[first,...,last]

	public void sort(int[] data) {

	}
	
	//TODO: override this method with a concrete (ie, not abstract) swap mechanism
	/**
	 * Swapping 2 indexes.
	 * @param data
	 * @param idx1
	 * @param idx2
	 */
	public void swap(int[] data, int idx1, int idx2) {
		int temp = data[idx1];
		data[idx1] = data[idx2];
		data[idx2] = temp;


		// instructions were unclear hand got stuck in toaster
	}
	
	public static void main(String[] args) {
		/* Choose your data set below */
		//int[] input2 = {1,5,2,4,3,6,9,7,8,2};
		//int[] input3 = {13,1,60,59,52,23,31};		
		int[] input = {3,1,5,18,23,25,4,14};
		int[] input2 = {3,1,5,18,23,25,4,14};
		//int[] input3 = {3,1,5,18,23,25,4,14};
		
		
		/* add or comment/uncomment your sort below */
		displaySortResults(new QuickSort(), input);
		displaySortResults(new BubbleSort(), input2);
		//displaySortResults(new SelectionSort(), input3);
		
	}
	
	public static void displaySortResults(Sort sorter, int[] data) {
		sorter.resetComparisons();

		System.out.println(Arrays.toString(data));
		
		sorter.sort(data, 0, data.length-1);
		sorter.sort(data);
				
		System.out.println(Arrays.toString(data));
		System.out.print(sorter.getClass().toString());
		System.out.println(",Comparisons: " + sorter.getComparisons()+"\n\n");
	}

	//Don't make changes to the code below.  What does the final modifier do?
	private int comparisons=0;
	
	public final int getComparisons() {
		return comparisons;
	}
	public final void resetComparisons() {
		comparisons = 0;
	}
	public final void incrementComparisons() {
		comparisons++;
	}
}
