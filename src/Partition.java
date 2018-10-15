import java.util.Arrays;

public class Partition {
	public static int partition(int[] a, int left, int right) {
		int pivot = a[left];
		int lspot = left+1;
		int rspot = right;
		int tempVal;
		while (lspot < rspot) {
			while(a[lspot] <= pivot && lspot < right) {
				lspot++;
			}
			while(a[rspot] >= pivot && rspot > left) {
				rspot--;
			}
			System.out.println("L:" + lspot);
			System.out.println("R:" + rspot);
			if (lspot <= rspot) {
				tempVal = a[lspot];
				a[lspot] = a[rspot];
				a[rspot] = tempVal;
			}
			System.out.println(Arrays.toString(a));
		}
		a[left] = a[rspot];
		a[rspot] = pivot;
		return rspot;
	}
	public static void main (String[] args) {
		int[] a1 = {5, 6, 2, 4, 1, 5};
		int middle = partition(a1, 0 , a1.length-1);
		System.out.println(Arrays.toString(a1) + "\tMID: " + middle);
	}
}
