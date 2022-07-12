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
		int target = 8;
		ArrayList<Integer> ds = new ArrayList<>();
		Collections.sort(array);

		combination(0, ds, array, target, n);
	}

	public static void combination(int index, ArrayList<Integer> ds, ArrayList<Integer> array, int target, int n) {
		if (target == 0) {
			System.out.println(ds);
			return;
		}

		for (int i = index; i < n; i++) {
			if (i > index && array.get(i) == array.get(i - 1)) {
				continue;
			}
			if (array.get(i) > target) break;

			ds.add(array.get(i));
			combination(i + 1, ds, array, target - array.get(i), n);
			ds.remove(ds.size() - 1);
		}

	}

}
