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
	
	/**
	 * Organizes an array of colors into the order of the dutch national flag 
	 * @param an array of colors, dictated by the colors enum 
	 * preconditions: a is non-empty
	 * postconditions: a is sorted such that the index of any arbitrary red element
	 *                 is less than any arbitrary white element and the index of any
	 *                 arbitrary white element is less than the index of any arbitrary
	 *                 blue element.
	 */
	public static void implementationA(Color[] a) {
        //All indices start before array since nothing is examined 
		int lastRed = -1;
        int lastWhite = -1;
        int lastBlue = -1;
        
        while(lastBlue < a.length-1) {
            if (a[lastBlue + 1].equals(Color.BLUE)) { //Blue comes next
                lastBlue++; //absorb it in blue 
            }
            else if (a[lastBlue + 1].equals(Color.WHITE)) { //white comes next 
                //swap last unexamined with white and continue
            	Color tempBlue= a[lastWhite + 1];
                a[lastWhite + 1] = a[lastBlue + 1];
                a[lastBlue + 1] = tempBlue;
                lastWhite++;
                lastBlue++;
            }
            else if (a[lastBlue + 1].equals(Color.RED)) {
                //Put unexamined in the red and continue
            	Color tempNew = a[lastBlue + 1];
                a[lastBlue + 1] = a[lastWhite + 1];
                a[lastWhite + 1] = a[lastRed + 1];
                a[lastRed + 1] = tempNew;
                lastRed++;
                lastWhite++;
                lastBlue++;
            }
        }
    }
	
	/**
	 * Organizes an array of colors into the order of the dutch national flag 
	 * @param an array of colors, dictated by the colors enum 
	 * preconditions: a is non-empty
	 * postconditions: a is sorted such that the index of any arbitrary red element
	 *                 is less than any arbitrary white element and the index of any
	 *                 arbitrary white element is less than the index of any arbitrary
	 *                 blue element.
	 */
	public static void implementationB(Color[] a) {
		int lastWhite = -1; //before array
		int lastRed = -1; //before array
		int firstBlue = a.length; //after array
		while (firstBlue > lastWhite && lastWhite < a.length-1) {
			if (a[lastWhite + 1].equals(Color.RED)) { //next examined is red 
				//swap unexamined with end of red and continue
				Color temp = a[lastRed+1];
				a[lastRed+1] = a[lastWhite + 1];
				a[lastWhite + 1] = temp;
				lastRed++;
				lastWhite++;
			}
			else if (a[lastWhite + 1].equals(Color.WHITE)) { //next examined is white
				//absorb it in white
				lastWhite++;
			}
			else if (a[lastWhite + 1].equals(Color.BLUE)) { //next examined is blue 
				if (lastWhite+1 == firstBlue) { // if there is only one value left 
					//just have blue absorb and stop
					firstBlue--;
				}
				else {
					//swap unexamined with blue and continue
					Color temp = a[firstBlue-1];
					a[firstBlue - 1] = a[lastWhite + 1];
					a[lastWhite + 1] = temp;
					firstBlue--;
				}
			}
		}
	}
	
	/**
	 * Testing of both implementations 
	 */
	public static void main(String[] args) {
		//variables for testing the various implementations
		boolean impA = false;
		boolean impB = false;
		if (impA) {
			Color[] c1 = {Color.RED, Color.WHITE, Color.BLUE};
	        implementationA(c1);
	        Color[] c2 = {Color.RED, Color.BLUE, Color.WHITE};
	        implementationA(c2);
	        Color[] c3 = {Color.BLUE, Color.RED, Color.WHITE};
	        implementationA(c3);
	        Color[] c4 = {Color.BLUE, Color.WHITE, Color.RED};
	        implementationA(c4);
	        Color[] c5 = {Color.WHITE, Color.RED, Color.BLUE};
	        implementationA(c5);
	        Color[] c6 = {Color.WHITE, Color.BLUE, Color.RED};
	        implementationA(c6);
	        Color[] c7 = {Color.WHITE, Color.BLUE, Color.RED, Color.BLUE, Color.WHITE, Color.RED, Color.BLUE, Color.WHITE, Color.RED};
	        implementationA(c7);
	        Color[] c8 = {Color.RED};
	        implementationA(c8);
	        Color[] c9 = {Color.WHITE};
	        implementationA(c9);
	        Color[] c10 = {Color.BLUE};
	        implementationA(c10);
	        Color[] c11 = {Color.RED, Color.BLUE};
	        implementationA(c11);
	        Color[] c12 = {Color.RED, Color.WHITE};
	        implementationA(c12);
	        Color[] c13 = {Color.WHITE, Color.BLUE};
	        implementationA(c13);
	        Color[] c14 = {Color.WHITE, Color.BLUE};
	        implementationA(c14);
	        Color[] c15 = {Color.BLUE, Color.RED};
	        implementationA(c15);
	        Color[] c16 = {Color.BLUE, Color.WHITE};
	        implementationA(c16);
	        System.out.println(Arrays.toString(c1));
	        System.out.println(Arrays.toString(c2));
	        System.out.println(Arrays.toString(c3));
	        System.out.println(Arrays.toString(c4));
	        System.out.println(Arrays.toString(c5));
	        System.out.println(Arrays.toString(c6));
	        System.out.println(Arrays.toString(c7));
	        System.out.println(Arrays.toString(c8));
	        System.out.println(Arrays.toString(c9));
	        System.out.println(Arrays.toString(c10));
	        System.out.println(Arrays.toString(c11));
	        System.out.println(Arrays.toString(c12));
	        System.out.println(Arrays.toString(c13));
	        System.out.println(Arrays.toString(c14));
	        System.out.println(Arrays.toString(c15));
	        System.out.println(Arrays.toString(c16));
		}
		else if (impB) {
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
	        Color[] c8 = {Color.RED};
	        implementationB(c8);
	        Color[] c9 = {Color.WHITE};
	        implementationB(c9);
	        Color[] c10 = {Color.BLUE};
	        implementationB(c10);
	        Color[] c11 = {Color.RED, Color.BLUE};
	        implementationB(c11);
	        Color[] c12 = {Color.RED, Color.WHITE};
	        implementationB(c12);
	        Color[] c13 = {Color.WHITE, Color.BLUE};
	        implementationB(c13);
	        Color[] c14 = {Color.WHITE, Color.BLUE};
	        implementationB(c14);
	        Color[] c15 = {Color.BLUE, Color.RED};
	        implementationB(c15);
	        Color[] c16 = {Color.BLUE, Color.WHITE};
	        implementationB(c16);
	        System.out.println(Arrays.toString(c1));
	        System.out.println(Arrays.toString(c2));
	        System.out.println(Arrays.toString(c3));
	        System.out.println(Arrays.toString(c4));
	        System.out.println(Arrays.toString(c5));
	        System.out.println(Arrays.toString(c6));
	        System.out.println(Arrays.toString(c7));
	        System.out.println(Arrays.toString(c8));
	        System.out.println(Arrays.toString(c9));
	        System.out.println(Arrays.toString(c10));
	        System.out.println(Arrays.toString(c11));
	        System.out.println(Arrays.toString(c12));
	        System.out.println(Arrays.toString(c13));
	        System.out.println(Arrays.toString(c14));
	        System.out.println(Arrays.toString(c15));
	        System.out.println(Arrays.toString(c16));
			return;
		}
	}
}
