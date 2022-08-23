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
		int w = scan.nextInt(), h = scan.nextInt(), t = scan.nextInt();

		ArrayList<Integer> wp = new ArrayList<>();
		ArrayList<Integer> hp = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			int wi = scan.nextInt();
			wp.add(wi);
			int hi = scan.nextInt();
			hp.add(hi);
		}

		wp.add(w + 1);
		hp.add(h + 1);

		Collections.sort(wp);
		Collections.sort(hp);

		System.out.println(defenseKingdom(wp, hp, t, w, h));
	}

	public int defenseKingdom(ArrayList<Integer> wp, ArrayList<Integer> hp, int tower, int w, int h) {
		if (tower == 0) return w * h;

		System.out.println(wp);
		System.out.println(hp);

		int maxw = hp.get(0) - 1, maxh = hp.get(0) - 1;

		for (int i = 1; i < wp.size(); i++) {
			maxw = Math.max(maxw, wp.get(i) - wp.get(i - 1) - 1);
			maxh = Math.max(maxh, hp.get(i) - hp.get(i - 1) - 1);
		}

		return maxh * maxw;
	}

}
