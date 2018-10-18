package invariants;
import invariants.Partition;

public class Median {
	public static int select(int[] a, int k) {
		if (a.length == 1) {
			return a[0];
		}
		int left = 0;
		int right = a.length -1;
		int middle = Partition.partition(a, left, right);
		while (k != middle + 1) {
			if (k <= middle - left) {
				middle = Partition.partition(a, left, middle - 1);
			}
			else if (k >= middle + left) {
				left = middle + 1; 
				middle = Partition.partition(a, left, right);
			}
		}
		return a[middle];
	}
	
	public static void main(String[] args) {
		int[] a1 = {3, 6, 2, 4, 1, 5};
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
	}
}
