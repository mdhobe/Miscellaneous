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
		ArrayList<Integer> ans = new ArrayList<>();
		combination(0, ans, array, n);
	}

	public static void combination(int index, ArrayList<Integer> ans, ArrayList<Integer> array, int n) {
		System.out.println(ans);
		if (index == n) {
			return;
		}
		for (int i = index; i < n; i++) {
			if (i > index && array.get(i) == array.get(i - 1)) continue;
			ans.add(array.get(i));
			combination(i + 1, ans, array, n);
			ans.remove(ans.size() - 1);
		}
	}

}
