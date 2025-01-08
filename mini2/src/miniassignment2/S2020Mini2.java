package miniassignment2;

import java.util.Random;
import java.util.Arrays;
import java.awt.List;
import java.util.ArrayList;

public class S2020Mini2 {
	public enum Direction {
		UP, LEFT, DOWN, RIGHT
	}

	private S2020Mini2() {
	}

	public static void main(String[] args) {
		System.out.println(binomialCoefficients(15));
		// System.out.println(factorial(15));
		// System.out.println(factorization(413423478));
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] c = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 21, 22, 23 };
		int[] d = { 1, 2, 3, 4, 5, 6, 7 };
		int[] e = { 1, 2, 5, 3, 8, 9 };
		boolean [][] f ={{false,false,false},{false,false,false},{false,false,false}};
		langtonsAnt(f,1,1,Direction.LEFT,100);

		System.out.println(Arrays.deepToString(f));
		
		// System.out.println(oddsToFront(d));
		// System.out.println(oddsToFront(e));
		// System.out.println(shuffle(new Random(1995), a));
		// System.out.println(interleave(b,c));

	}

	public static int[] binomialCoefficients(int n)
	// public static String binomialCoefficients(int n)
	{
		int[] a = new int[n + 1];
		int[] b = new int[n];
		for (int i = 0; i < n + 1; i++) {
			a[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			b[i] = 0;
		}

		for (int j = 0; j < n + 1; j++) {
			a[j] = 1;
			for (int h = 0; h < n - 1; h++) {

				a[h + 1] = b[h] + b[h + 1];

			}

			for (int k = 0; k < n; k++) {
				b[k] = a[k];
			}
		}

		return a;
		// return Arrays.toString(a);

	}

	public static int[] factorization(int n)
	// public static String factorization(int n)
	{
		int number = n;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= number; i++) {
			while (number % i == 0) {
				factors.add(i);
				number = number / i;
			}
		}

		int[] output = new int[factors.size()];
		for (int i = 0; i < factors.size(); i++) {
			output[i] = factors.get(i);
		}
		return output;
		// return Arrays.toString(output);
	}

	public static void oddsToFront(int[] a)
	// public static String oddsToFront(int[] a)
	{
		int[] arr = new int[a.length];
		int n = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				arr[n] = a[i];
				n++;
			}
		}

		for (int j = 0; j < a.length; j++) {
			if (a[j] % 2 == 0) {
				arr[n] = a[j];
				n++;
			}
		}
		for (int h = 0; h < a.length; h++) {
			a[h] = arr[h];
		}
		// return Arrays.toString(a);
	}

	public static int[] interleave(int[] a, int[] b)
	// public static String interleave(int[] a, int[] b)
	{
		int[] arr = new int[a.length + b.length];
		int len = Math.min(a.length, b.length);
		for (int i = 0; i < len; i++) {
			arr[2 * i] = a[i];
			arr[2 * i + 1] = b[i];
		}

		if (a.length > b.length) {

			for (int j = 2 * len; j < arr.length; j++) {
				arr[j] = a[j - len];
			}
		}
		if (a.length < b.length) {

			for (int j = 2 * len; j < arr.length; j++) {
				arr[j] = b[j - len];
			}
		}
		return arr;

		// return Arrays.toString(arr);
	}

	public static void shuffle(Random r, int[] a)
	// public static String shuffle(Random r, int[] a)
	{
		// Random r = new Random(r);
		for (int i = 0; i < a.length; i++) {
			int j = r.nextInt(a.length);
			int c = a[i];
			a[i] = a[j];
			a[j] = c;
		}
		// return Arrays.toString(a);
	}

	public static void langtonsAnt(boolean[][] m, int c, int r, Direction d, int maxSteps) 	
	{

		int l = m.length;
		int w = m[0].length;
		int f = 0;

		if (d == Direction.UP) {
			f = 0;
		}

		if (d == Direction.RIGHT) {
			f = 1;
		}

		if (d == Direction.DOWN) {
			f = 2;
		}

		if (d == Direction.LEFT) {
			f = 3;
		}

		for (int k = 0; k < maxSteps; k++) {
			if (m[r][c] == true) {
				f = (f + 1) % 4;
				if (f == 0) {
					m[r][c] = false;
					r = r - 1;
					c = c;
				} if (f == 1) {
					m[r][c] = false;
					r = r;
					c = c + 1;
				} if (f == 2) {
					m[r][c] = false;
					r = r + 1;
					c = c;
				} if (f == 3) {
					m[r][c] = false;
					r = r;
					c = c - 1;
				}
			} else {
				f = (f + 3) % 4;
				if (f == 0) {
					m[r][c] = true;
					r = r - 1;
					c = c;
				} if (f == 1) {
					m[r][c] = true;
					r = r;
					c = c + 1;
				} if (f == 2) {
					m[r][c] = true;
					r = r + 1;
					c = c;
				} if (f == 3) {
					m[r][c] = true;
					r = r;
					c = c - 1;
				}
			}
			
			if (c<0 || r<0 || r>l-1|| c>w-1) {
				break;
			}
		}
		//return m;
		//return Arrays.toString(m[c]);
	}

}
