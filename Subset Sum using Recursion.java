import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < n; i++) array.add(sc.nextInt());
		Collections.sort(array);

		combination(0, array, n, 0);
	}

	public static void combination(int index, ArrayList<Integer> array, int n, int sum) {
		if (index == n) {
			System.out.println(sum);
			return;
		}
		combination(index + 1, array, n, sum + array.get(index));
		combination(index + 1, array, n, sum);
	}

}
