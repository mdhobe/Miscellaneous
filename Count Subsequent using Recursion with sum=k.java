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

		System.out.println(subset(0, array, n, 0, sum, 0));
	}

	public static int subset(int index, ArrayList<Integer> array, int n, int psum, int sum, int count) {
		if (index == n) {
			if (sum == psum) {
				return 1;
			}
			return 0;
		}
		//take
		psum += array.get(index);
		int count1 = subset(index + 1, array, n, psum, sum, count);
		psum -= array.get(index);
		int count2 = subset(index + 1, array, n, psum, sum, count);
		return count2 + count1;
	}
}
