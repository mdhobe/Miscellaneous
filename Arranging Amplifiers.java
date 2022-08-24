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
		int[] a = {1, 2, 1, 3};

		ArrayList<Integer> amplifiers = new ArrayList<>();

		for (int num : a)if (num != 1) amplifiers.add(num);

		amplify(amplifiers, a.length - amplifiers.size());
	}

	public void amplify(ArrayList<Integer> amplifiers, int one) {
		Collections.sort(amplifiers, Collections.reverseOrder());

		if (amplifiers.size() == 2) {
			if (amplifiers.get(0) == 2 && amplifiers.get(1) == 3) {
				System.out.println("[2, 3]");
				return;
			} else if (amplifiers.get(1) == 2 && amplifiers.get(0) == 3) {
				System.out.println("[2, 3]");
				return;
			}
		}

		while (one -- > 0) amplifiers.add(0, 1);

		System.out.println(amplifiers);
	}

}
