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
		int k = 100;
		int[] prices = {7, 10, 4};

		ArrayList<ArrayList<Integer>> myprices = new ArrayList<>();
		for (int i = 0; i < prices.length; i++) {
			ArrayList<Integer> price = new ArrayList<>();
			price.add(i + 1);
			price.add(prices[i]);
			myprices.add(new ArrayList(price));
		}

		Collections.sort(myprices, (a, b) -> {
			return a.get(1) - b.get(1);
		});

		maxstocks(myprices, k);
	}

	public void maxstocks(ArrayList<ArrayList<Integer>> myprices, int k) {
		System.out.println(myprices);

		int count = 0;

		for (int i = 0; i < myprices.size(); i++) {
			int quantity = k / myprices.get(i).get(1);
			if (quantity >= myprices.get(i).get(0)) {
				count += myprices.get(i).get(0);
				k -= myprices.get(i).get(0) * myprices.get(i).get(1);
			} else {
				count += quantity;
				k -= quantity * myprices.get(i).get(1);
			}
		}

		System.out.println(count);
	}
}
