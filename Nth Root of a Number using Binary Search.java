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
		int m = scan.nextInt();
		sqroot(n, m);
	}

	public double sqroot(int n, int m) {
		double low = 1;
		double high = m;
		double eps = 1e-6;

		while ((high - low) > eps) {
			double mid = (high + low) / 2.0;
			if (multiply(mid, n) < m) {
				low = mid;
			} else {
				high = mid;
			}
		}

		System.out.println(low + " " + high);

		return low;
	}

	public double multiply(double mid, int n) {
		double ans = 1.0;
		for (int i = 1; i <= n; i++) ans = ans * mid;
		return ans;
	}

}
