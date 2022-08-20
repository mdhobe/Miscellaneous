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
		int value = scan.nextInt();

		minCoins(value);
	}

	public void minCoins(int value) {
		int ans = 0;
		int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1 };

		for (int coin : coins) {
			if (value >= coin && value > 0) {
				int n = value / coin;
				System.out.println(coin + " " + n);
				value -= n * coin;
				ans += n;
			} else break;
		}

		System.out.println(ans);
	}
}
