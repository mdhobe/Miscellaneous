import java.io.*;
import java.util.*;

public class C {
	char[][] alpha = {
		{'a', 'b', 'c'},
		{'d', 'e', 'f'},
		{'g', 'h', 'i'},
		{'j', 'k', 'l'},
		{'m', 'n', 'o'},
		{'p', 'q', 'r', 's'},
		{'t', 'u', 'v'},
		{'w', 'x', 'y', 'z'}
	};
	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		String str = "234";
		ArrayList<Character> ans = new ArrayList<>();
		combination(0, str, ans);

	}
	public void combination(int index, String input, ArrayList<Character> ans) {
		if (index == input.length()) {
			System.out.println(ans);
			return;
		}
		for (char c : [Character.getNumericValue(input.charAt(index)) - 2]) {
			ans.add(c);
			combination(index + 1, input, ans);
			ans.remove(ans.size() - 1);
		}
	}
}
