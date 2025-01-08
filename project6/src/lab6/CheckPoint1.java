package lab6;

import java.util.Scanner;

public class CheckPoint1 {

	public static void main(String[] args) {
		System.out.println(initials("Liang Yu Pin"));
		System.out.println(VowelIndex("Lngaa"));
	}

	public static String initials(String s) {
		Scanner scan = new Scanner(s);
		String ss = "";
		while (scan.hasNext()) {
			char first = scan.next().charAt(0);
			ss = ss + first;
		}
		return ss;
	}

	public static int VowelIndex(String s) {
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I'
					|| s.charAt(i) == 'O' || s.charAt(i) == 'U') {
				index = i;
				break;
			}
		}
		return index;
	}

}
