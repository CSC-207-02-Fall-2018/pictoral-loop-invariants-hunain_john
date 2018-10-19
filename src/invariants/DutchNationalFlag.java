package invariants;

import java.util.Arrays;

/**
 * an simple enum of colors necessary for the problem
 */
enum Color {
	RED, WHITE, BLUE
}

/**
 * A class containing 2 static implementations of a solution to the DutchNationalFlag problem 
 */
public class DutchNationalFlag {
	
	public static void implementationB(Color[] a) {
		int lastWhite = -1;
		int lastRed = -1;
		int firstBlue = a.length;
		while (firstBlue > lastWhite) {
			if (a[lastWhite + 1].equals(Color.RED)) {
				Color temp = a[lastRed+1];
				a[lastRed+1] = a[lastWhite + 1];
				a[lastWhite + 1] = temp;
				lastRed++;
				lastWhite++;
			}
			else if (a[lastWhite + 1].equals(Color.WHITE)) {
				lastWhite++;
			}
			else if (a[lastWhite + 1].equals(Color.BLUE)) {
				if (lastWhite+1 == firstBlue) {
					firstBlue--;
				}
				else {
					Color temp = a[firstBlue-1];
					a[firstBlue - 1] = a[lastWhite + 1];
					a[lastWhite + 1] = temp;
					firstBlue--;
				}
			}
		}
		
	}
	
	public static void implementationC(Color[] a) {
		
	}
	
	public static void main(String[] args) {
		Color[] c1 = {Color.RED, Color.WHITE, Color.BLUE};
		implementationB(c1);
		Color[] c2 = {Color.RED, Color.BLUE, Color.WHITE};
		implementationB(c2);
		Color[] c3 = {Color.BLUE, Color.RED, Color.WHITE};
		implementationB(c3);
		Color[] c4 = {Color.BLUE, Color.WHITE, Color.RED};
		implementationB(c4);
		Color[] c5 = {Color.WHITE, Color.RED, Color.BLUE};
		implementationB(c5);
		Color[] c6 = {Color.WHITE, Color.BLUE, Color.RED};
		implementationB(c6);
		Color[] c7 = {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE, Color.RED, Color.BLUE, Color.WHITE, Color.RED};
		implementationB(c7);
		Color[] c8 = {};
		implementationB(c8);
		System.out.println(Arrays.toString(c1));
		System.out.println(Arrays.toString(c2));
		System.out.println(Arrays.toString(c3));
		System.out.println(Arrays.toString(c4));
		System.out.println(Arrays.toString(c5));
		System.out.println(Arrays.toString(c6));
		System.out.println(Arrays.toString(c7));
		System.out.println(Arrays.toString(c8));
		
	}
}
