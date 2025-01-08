package miniassignment1;

import java.util.Random;
import java.awt.List;
import java.util.ArrayList;

public class S2020Mini1 {

	public static void main(String args[]) {
		//String s = "apple";
		//System.out.println(countDifferences("appl", "apple"));
		//System.out.println(squareRoot(4.8));
		//System.out.println(findSmallest("ppbplale"));
		//System.out.println(isGeometric("2,4,6,8,10"));
		//System.out.println(isGeometric("1,3,6,9090,14"));
		//System.out.println(removeSingles("aapvvfw"));
		// System.out.println(sequenceOfLength(new Random(1984), 10, 9));
		System.out.println(nextIndexOf("aooohello", "hello", 1));
		//System.out.println(removeSingles("aaaa"));
	}

	public static int countDifferences(String s, String t) {
		int c = 0;
		if (s.length() <= t.length()) {

			for (int i = 0; i < s.length(); i++) {
				char a = s.charAt(i);

				for (int j = 0; j < t.length(); j++) {
					char b = t.charAt(j);
					if (a != b) {

						c = j + 1;
					}
				}
			}
		}

		else {
			for (int i = 0; i < t.length(); i++) {
				char a = t.charAt(i);

				for (int j = 0; j < s.length(); j++) {
					char b = s.charAt(j);
					if (a != b) {

						c = j + 1;

					}
				}

			}
		}
		return c;
	}

	public static double squareRoot(double d) {
		double a = d;
		double number = d;
		for (int i = 0; i < 500; i++) {
			number = 0.5 * (number + a / number);
		}

		return number;
	}

	public static int findSmallest(String s) {
		char[] ch = s.toCharArray();
		char min = ch[0];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (min > ch[i]) {
				min = ch[i];
				index = i;
			}
		}
		return index;
	}

	public static int sequenceOfLength(Random r, int limit, int length) {

		int count = 0;
		while (true) {
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = r.nextInt(limit);
			}
			count++;

			boolean found = true;
			for (int i = 1; i < length; i++) {
				if (arr[i] - arr[i - 1] != 1) {
					found = false;
					break;
				}
			}
			if (found) {
				break;
			}
		}
		return count;
	}

	public static int nextIndexOf(String s, String sub, int start) {
		int n = 0;
		int j =0;
		for (int i = 0; i < s.length(); i++) {
			int n1 = 0;
			if (s.charAt(i) == sub.charAt(0)) {
				for ( j = 0; j < sub.length(); j++) {
					if (s.charAt(i+j) != sub.charAt(j)) {
						break;
					}
					
					n1=n1+1;
					//System.out.println(n1);
				}
				
				
				
				
				if (n1==sub.length()) {
					break;
				} 
				
				else {
					n = n + 1;
				}
			} 
			
			else {
				n = n + 1;
			}

		}
		return (n - start);
	}

	public static boolean isGeometric(String seq) {
		String[] given = seq.split(",");
		int[] arr = new int[given.length];

		for (int i = 0; i < given.length; i++) {
			arr[i] = Integer.parseInt(given[i]);
		}
		boolean G = true;

		for (int j = 1; j < given.length - 1; j++) {

			if ((arr[j - 1] / arr[j]) != (arr[j] / arr[j + 1])) {
				G = false;
			}
		}
		return G;
	}

	public static String removeSingles(String s) {
		String a = "";
		for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i)==s.charAt(i+1)) {
					int index = i;
					 a = a + s.substring(i,i+2);
					
				}
			}
		return a;
	}

}
