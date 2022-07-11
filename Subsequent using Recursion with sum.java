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
		int sum = 4;
		ArrayList<Integer> ds = new ArrayList<>();

		subset(0, ds, array, n, 0, sum);
	}

	public static void subset(int index, ArrayList<Integer> ds, ArrayList<Integer> array, int n, int psum, int sum) {
		if (index == n) {
			if (sum == psum) {
				System.out.println(ds);
			}
			return;
		}
		//take
		ds.add(array.get(index));
		psum += array.get(index);
		subset(index + 1, ds, array, n, psum, sum);
		ds.remove(ds.size() - 1);
		psum -= array.get(index);
		subset(index + 1, ds, array, n, psum, sum);
	}
}
