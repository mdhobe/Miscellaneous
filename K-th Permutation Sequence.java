import java.io.*;
import java.util.*;

public class B {
	public static char[] directions = { 'D', 'L', 'R', 'U' };
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 1; i <= n; i++) array.add(i);
		ArrayList<Integer> ans = new ArrayList<>();
		permutation(array, ans, n, k - 1);
		System.out.println(ans);
	}

	public static void permutation(ArrayList<Integer> array, ArrayList<Integer> ans, int n, int k) {
		if (ans.size() == n) {
			return;
		}
		if (array.size() > 0) {
			int fact = factorial(array.size() - 1);
			int index = k / fact;
			int num = array.get(index);
			ans.add(num);
			array.remove(index);
			permutation(array, ans, n, k % fact);
		} else {
			ans.add(array.get(0));
		}
	}

	public static int factorial(int n) {
		int num = 1;
		while (n > 1) num *= n--;
		return num;
	}
}
