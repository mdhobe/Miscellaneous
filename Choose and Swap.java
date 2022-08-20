import java.io.*;
import java.util.*;

public class C {
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String str = "ccad";

		chooseandswap(str);
	}

	public void chooseandswap(String str) {
		char[] chars = str.toCharArray();
		HashSet<Character> uniques = new HashSet<>();

		char one = 'a', two = 'a';

		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				if (i != j && !uniques.contains(chars[j]) && chars[i] > chars[j]) {
					one = chars[i];
					two = chars[j];
					break;
				}
			}
			uniques.add(chars[i]);
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == one) chars[i] = two;
			else if (chars[i] == two) chars[i] = one;
		}

		System.out.println(String.copyValueOf(chars));
	}
}
