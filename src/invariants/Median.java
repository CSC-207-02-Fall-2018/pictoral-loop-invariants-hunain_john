package invariants;
import invariants.Partition;

/**
 * A class implementing the static select and median methods 
 */
public class Median {
	
	/**
	 * 
	 * @param a an array of integers you're selecting from
	 * @param k the kth smallest element of the array that you want
	 * @return the kth smallest element of the array
	 * precondtions: 1 <= k <= length; a.length >= 1;
	 * postconditions: array is partitioned by the partition method (Described in Partition.java) 
	 */
	public static int select(int[] a, int k) {
		//the the k you would expect is one, so return the only item in the array
		if (a.length == 1) {
			return a[0];
		}
		//Initial values for partition and partition
		int left = 0;
		int right = a.length -1;
		int middle = Partition.partition(a, left, right);
		
		//While we have yet to find the kth smallest 
		while (middle != k-1) {
			//Look at the left half of the portion we just partitioned 
			//if middle is larger than the k we want
			if (k <= middle) {
				right = middle -1; 
				middle = Partition.partition(a, left, right);
			}
			
			//Look at the right half of the portion we just partitioned 
			//if middle is smaller than the k we want
			else if (k > middle) {
				left = middle + 1; 
				middle = Partition.partition(a, left, right);
			}
		}
		//Return the correct value once we've found it
		return a[middle];
	}
	
	/**
	 * Finds Median of an array of integers.
	 * pre-condition: none
	 * @param an array of integers
	 * @return the medium element from the array
	 * post-condition: If odd number of elements in array a, return the true median.
	 * post-condition: If even number of elements in array a, return the ((a.length+1)/2)th smallest element.
	 */
	public static int median(int[] a) {
		int medianIndex = (int)Math.ceil((double)(a.length+1) / 2);
		
		return select(a, medianIndex);
	}
	
	/**
	 * Testing for select and median methods 
	 */
	public static void main(String[] args) {
		System.out.println("First array: ");
		int[] a1 = {3, 6, 2, 4, 1, 5};
		int[] a2 = {6, 2, 1, 5, 3, 4};
		int smallest1 = select(a1, 1);
		int smallest2 = select(a1, 2);
		int smallest3 = select(a1, 3);
		int smallest4 = select(a1, 4);
		int smallest5 = select(a1, 5);
		int smallest6 = select(a1, 6);
		System.out.println("Smallest1:" + smallest1);
		System.out.println("Smallest2:" + smallest2);
		System.out.println("Smallest3:" + smallest3);
		System.out.println("Smallest4:" + smallest4);
		System.out.println("Smallest5:" + smallest5);
		System.out.println("Smallest6:" + smallest6);
		
		System.out.println("\nSecond array: ");
		int bsmallest1 = select(a2, 1);
		int bsmallest2 = select(a2, 2);
		int bsmallest3 = select(a2, 3);
		int bsmallest4 = select(a2, 4);
		int bsmallest5 = select(a2, 5);
		int bsmallest6 = select(a2, 6);
		System.out.println("Smallest1:" + bsmallest1);
		System.out.println("Smallest2:" + bsmallest2);
		System.out.println("Smallest3:" + bsmallest3);
		System.out.println("Smallest4:" + bsmallest4);
		System.out.println("Smallest5:" + bsmallest5);
		System.out.println("Smallest6:" + bsmallest6);
		
		int[] m1 = {1};
		int median1 = median(m1);
		System.out.println("Median1:" + median1);
		int[] m2 = {1, 3};
		int median2 = median(m2);
		System.out.println("Median2:" + median2);
		int[] m3 = {1, 3, 7};
		int median3 = median(m3);
		System.out.println("Median3:" + median3);
		int[] m4 = {1, 3, 7, 8};
		int median4 = median(m4);
		System.out.println("Median4:" + median4);
		int[] m5 = {1, 7, 3, 8, 2};
		int median5 = median(m5);
		System.out.println("Median5:" + median5);
		int[] m6 = {1, 7, 4, 8, 2, 4};
		int median6 = median(m6);
		System.out.println("Median6:" + median6);
		
	}
}
