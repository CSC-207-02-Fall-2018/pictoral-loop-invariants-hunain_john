package invariants;
import java.util.Arrays;

import invariants.Partition;

public class Quicksort {
	private static void quicksortKernel(int[] a, int left, int right) {
		if (right - left <= 0) {
			return;
		}
		else {
			int middle = Partition.partition(a, left, right);
			quicksortKernel(a, left, middle-1);
			quicksortKernel(a, middle+1, right);
		}
	}
	
	public static void quicksort (int a[]) {
        quicksortKernel (a, 0, a.length-1);
     }
	public static void main (String[] args) {
		
		int[] a1 = {1};
		quicksort(a1);
		System.out.println(Arrays.toString(a1));
		int[] a2 = {1, 2};
		quicksort(a2);
		System.out.println(Arrays.toString(a2));
		int[] a3 = {1, 2, 3};
		quicksort(a3);
		System.out.println(Arrays.toString(a3));
		int[] a4 = {1, 3, 7, 8};
		quicksort(a4);
		System.out.println(Arrays.toString(a4));
		int[] a5 = {1, 7, 3, 8, 2};
		quicksort(a5);
		System.out.println(Arrays.toString(a5));
		int[] a6 = {1, 7, 4, 8, 2, 4};
		quicksort(a6);
		System.out.println(Arrays.toString(a6));
		
		
//		int[] a1 = {3, 6, 2, 4, 1, 5};
//		int[] a2 = {6, 3, 2, 4, 1, 5};
//		int[] a3 = {1, 5, 2, 4, 3, 6};
//		quicksort(a1);
//		quicksort(a2);
//		quicksort(a3);
//		System.out.println(Arrays.toString(a1));
//		System.out.println(Arrays.toString(a2));
//		System.out.println(Arrays.toString(a3));
	}
}
