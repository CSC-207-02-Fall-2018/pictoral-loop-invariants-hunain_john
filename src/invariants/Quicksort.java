package invariants;
import java.util.Arrays;
import invariants.Partition;

/**
 * A class implementing a static quicksort method on an array of integers 
 */
public class Quicksort {
	
	/**
	 * Recursive kernel for the quicksort method
	 * @param a the array to be sorted 
	 * @param left, the left bound of the portion of array that is to be sorted 
	 * @param right, the right bound of the portion of the array that is to be sorted
	 * preconditions: this method should only be called by quicksort
	 * postconditions: same as quicksort 
	 */
	private static void quicksortKernel(int[] a, int left, int right) {
		//Base case: stop if right and left pass or equal each other
		if (right - left <= 0) {
			return;
		}
		//Recursive case: Sort the left and right portion of the partitioned array
		else {
			int middle = Partition.partition(a, left, right);
			quicksortKernel(a, left, middle-1);
			quicksortKernel(a, middle+1, right);
		}
	}
	
	/**
	 * An implementation of quicksort for int[]
	 * @param a an array of integers to be sorted 
	 * preconditions: none 
	 * postconditions: a is changed to be sorted in ascending order
	 */
	public static void quicksort (int a[]) {
        quicksortKernel (a, 0, a.length-1);
     }
	
	/**
	 * Testing for the quicksort method
	 */
	public static void main (String[] args) {
		
		int[] a1 = {1};
		quicksort(a1);
		System.out.println(Arrays.toString(a1));
		int[] a2 = {2, 1};
		quicksort(a2);
		System.out.println(Arrays.toString(a2));
		int[] a3 = {1, 3, 2};
		quicksort(a3);
		System.out.println(Arrays.toString(a3));
		int[] a4 = {1, 3, 7, 8};
		quicksort(a4);
		System.out.println(Arrays.toString(a4));
		int[] a5 = {3, 7, 1, 8, 2};
		quicksort(a5);
		System.out.println(Arrays.toString(a5));
		int[] a6 = {4, 7, 3, 8, 2, 4};
		quicksort(a6);
		System.out.println(Arrays.toString(a6));
	}
}
