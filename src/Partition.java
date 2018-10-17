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
	 * preconditions: left >= 0, right <= a.length -1 
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
			if (lspot <= rspot) {
				tempVal = a[lspot];
				a[lspot] = a[rspot];
				a[rspot] = tempVal;
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
		int[] a1 = {5, 6, 2, 4, 1, 5};
		int middle = partition(a1, 0 , a1.length-1);
		System.out.println(Arrays.toString(a1) + "\tMID: " + middle);
	}
}
