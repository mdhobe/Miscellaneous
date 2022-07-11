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

		ArrayList<Integer> ds = new ArrayList<>();

		subset(0, array, ds, n);
	}

	public static void subset(int index, ArrayList<Integer> array, ArrayList<Integer> ds, int n) {
		if (index == n) {
			System.out.println(ds);
			return;
		}
		ds.add(array.get(index));
		subset(index + 1, array, ds, n);
		ds.remove(ds.size() - 1);
		subset(index + 1, array, ds, n);
	}
}
