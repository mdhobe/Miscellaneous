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
		int n = scan.nextInt();
		int[] vertical = {4, 3, 2, 1, 1};
		int[] horizontal = {4, 2, 1};

		// Arrays.sort(vertical, Collections.reverseOrder());
		// Arrays.sort(horizontal, Collections.reverseOrder());

		totalcuts(vertical, horizontal);
	}

	public int totalcuts(int[] vertical, int[] horizontal) {
		int ans = 0;
		int v = 1, h = 1, vp = 0, hp = 0;

		while (vp < vertical.length && hp < horizontal.length) {
			if (vertical[vp] >= horizontal[hp]) {
				ans += vertical[vp] * h;
				v++;
				vp++;
			} else {
				ans += horizontal[hp] * v;
				h++;
				hp++;
			}
		}

		while (vp < vertical.length) {
			ans += vertical[vp] * h;
			vp++;
		}

		while (hp < horizontal.length) {
			ans += horizontal[hp] * v;
			hp++;
		}

		System.out.println(ans);

		return ans;
	}
}
