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
		int s = 56, d = 6;
		System.out.println(smallestNumber(s, d));
	}

	public String smallestNumber(int S, int D) {

		if (9 * D < S) return "-1";
		else {
			StringBuilder ans = new StringBuilder();
			for (int i = 0; i < D; i++) ans.append("0");

			for (int i = D - 1; i >= 0; i--) {
				if (S > 9) {
					ans.setCharAt(i, '9');
					S -= 9;
				} else {
					ans.setCharAt(i,  (char) (S + '0'));
					break;
				}
			}

			if (ans.charAt(0) == '0') {
				ans.setCharAt(0, '1');
				for (int i = 1; i < D; i++) {
					if (ans.charAt(i) > '0') {
						int a = Character.getNumericValue(ans.charAt(i));
						a--;
						ans.setCharAt(i, (char) (a + '0'));
						break;
					}
				}
			}
			return ans.toString();
		}

	}

}
