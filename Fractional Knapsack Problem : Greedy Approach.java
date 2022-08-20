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
		int w = scan.nextInt();
		int[] values = {100, 60, 120}, weight =  {20, 10, 30};

		ArrayList<ArrayList<Integer>> vws = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> vw = new ArrayList<>();
			vw.add(values[i]);
			vw.add(weight[i]);
			vws.add(new ArrayList(vw));
		}

		//decending order
		Collections.sort(vws, (a, b)-> {
			return -1 * (a.get(0) / a.get(1) - b.get(0) / b.get(1));
		});

		maxValue(vws, w);
	}

	public void maxValue(ArrayList<ArrayList<Integer>> vws, int w) {
		System.out.println(vws);
		double ans = 0;

		for (int i = 0; i < vws.size(); i++) {
			if (w >= vws.get(i).get(1)) {
				w -= vws.get(i).get(1);
				ans += vws.get(i).get(0);
			} else {
				ans += (w * vws.get(i).get(0)) / vws.get(i).get(1);
				break;
			}
		}

		System.out.println(ans);
	}
}
