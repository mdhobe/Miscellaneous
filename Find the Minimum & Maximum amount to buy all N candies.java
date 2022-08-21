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
		int k = 4;
		int[] candies = {3, 2, 1, 4, 5};

		Arrays.sort(candies);

		maxminprice(candies, k);
	}

	public void maxminprice(int[] candies, int k) {
		int min = 0;
		int minleftp = 0, minrightp = candies.length;
		while (minrightp - minleftp > 0) {
			min += candies[minleftp];
			minleftp += 1;
			minrightp -= k;
		}
		System.out.println(min);

		int max = 0;
		int maxlefttp = -1, maxrightp = candies.length - 1;
		while (maxrightp - maxlefttp > 0) {
			max += candies[maxrightp];
			maxlefttp += k;
			maxrightp -= 1;
		}

		System.out.println(max);
	}
}
