import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) throws IOException {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<String> array = new ArrayList<>();
		palindrome(s, 0, s.length(), array);
	}

	public static void palindrome(String s, int index, int n, ArrayList<String> array) {
		if (index == n) {
			System.out.println(array);
			return;
		}
		for (int i = index; i < n; ++i) {
			if (isValid(s.substring(index, i + 1))) {
				array.add(s.substring(index, i + 1));
				palindrome(s, i + 1, n, array);
				array.remove(array.size() - 1);
			}
		}
	}

	public static boolean isValid(String s) {
		StringBuilder r = new StringBuilder(s).reverse();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != r.charAt(i)) return false;
		}
		return true;
	}

}
