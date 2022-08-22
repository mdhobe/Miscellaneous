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
		int s = scan.nextInt(), n = scan.nextInt(), m = scan.nextInt();

		System.out.println(survival(s, n, m));
	}

	public boolean survival(int s, int n, int m) {
		if (m > n) return false;

		if (m * s <= (s - s / 7) * n) {
			System.out.println((m * s) / n + (m * s) / (7 * n));
			return true;
		} else return false;
	}
}
