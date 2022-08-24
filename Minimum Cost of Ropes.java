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
		long[] arr = {4, 2, 7, 6, 9};
		System.out.println(minCost(arr, arr.length));
	}

	public long minCost(long[] arr, int n) {
		if (arr.length == 1) return 0;

		PriorityQueue<Long> cost = new PriorityQueue<>();
		for (long num : arr) cost.add(num);
		long ans = 0;

		while (cost.size() > 1) {
			long one = cost.peek();
			cost.poll();
			long two = cost.peek();
			cost.poll();

			ans += one + two;
			cost.add(one + two);
		}

		return ans;
	}

}
