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
		int sum = 7;
		ArrayList<Integer> ds = new ArrayList<>();

		combination(0, ds, array, sum, n);
	}

	public static void combination(int index, ArrayList<Integer> ds, ArrayList<Integer> array, int sum, int n) {
		if (sum == 0) {
			System.out.println(ds);
			return;
		} else if (sum < 0) {
			return;
		} else if (index == n) {
			return;
		}

		ds.add(array.get(index));
		combination(index, ds, array, sum - array.get(index), n);
		ds.remove(ds.size() - 1);
		combination(index + 1, ds, array, sum, n);
	}

}
