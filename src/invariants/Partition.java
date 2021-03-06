package invariants;
import java.util.Arrays;

/**
 *A class implementing the static partition method (used in various other methods)
 */
public class Partition {
	
	/**
	 * Takes a portion of an array and puts the pivot value in the middle  
	 * @param an array of integers 
	 * @param the location of the value being chosen as a pivot 
	 * @param the location of the last element sorted in relation to the pivot
	 * @return the location of the pivot value after its inserted in the middle 
	 * preconditions: left >= 0, right <= a.length -1, left <= right, a.length >= 1
	 * postconditions: the value at a[left] is placed switch with another value and the entire array between 
	 *                 a[left](new) and a[left](old) are <= a[left](old)  and all values between a[left](old)
	 *                 and a[right] are >= a[left](old)
	 */
	public static int partition(int[] a, int left, int right) {
		int pivot = a[left];
		int lspot = left+1; //first of the left unexamined values 
		int rspot = right; //first of the right unexamined values 
		int tempVal;
		while (lspot <= rspot) {
			//while the smaller values are on the appropriate side 
			while(a[lspot] <= pivot && lspot < right) {
				lspot++;
			}
			//while the larger values are on the appropriate side  
			while(a[rspot] >= pivot && rspot > left) {
				rspot--;
			}
			//Swap when values are in wrong place, provided the spots haven't crossed
			if (lspot < rspot) {
				tempVal = a[lspot];
				a[lspot] = a[rspot];
				a[rspot] = tempVal;
			}
			//If lspot equals rspot, only one of them should move
			if (lspot == rspot) {
				if (a[lspot] <= pivot) {
					lspot++;
				}
				else if (a[rspot] > pivot){
					rspot--;
				}
			}
		}
		//Moving pivot to the middle
		a[left] = a[rspot];
		a[rspot] = pivot;
		return rspot;
	}
	
	/**
	 * Testing for the partition method  	 
	 */
	public static void main (String[] args) {
		int[] a1 = {3, 6, 2, 4, 1, 5};
		int[] a2 = {6, 3, 2, 4, 1, 5};
		int[] a3 = {1, 5, 2, 4, 3, 6}; 
		int[] a4 = {5, 6, 2, 4, 1, 5};
		int[] a5 = {3, 6, 2, 4, 1, 5};
		int[] a6 = {3};
		int[] a7 = {6, 5};
		int middle1 = partition(a1, 0 , a1.length-1);
		System.out.println(Arrays.toString(a1) + "\tMID: " + middle1);
		int middle2 = partition(a2, 0 , a2.length-1);
		System.out.println(Arrays.toString(a2) + "\tMID: " + middle2);
		int middle3 = partition(a3, 0 , a3.length-1);
		System.out.println(Arrays.toString(a3) + "\tMID: " + middle3);
		int middle4 = partition(a4, 0 , a4.length-1);
		System.out.println(Arrays.toString(a4) + "\tMID: " + middle4);
		int middle5 = partition(a5, 1 , 4);
		System.out.println(Arrays.toString(a5) + "\tMID: " + middle5);
		int middle6 = partition(a6, 0 , 0);
		System.out.println(Arrays.toString(a6) + "\tMID: " + middle6);
		int middle7 = partition(a7, 0 , 1);
		System.out.println(Arrays.toString(a7) + "\tMID: " + middle7);
	}
}
