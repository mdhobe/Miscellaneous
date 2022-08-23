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
		int h = scan.nextInt(), a = scan.nextInt();

		System.out.println(harddie(h, a));
	}

	public int harddie(int h, int a) {
		int survive = 0;
		char current = 'a';

		while (h > 0 && a > 0) {
			if (current == 'a') {
				survive += 1;
				h += 3;
				a += 2;
				if (h > 20 && a <= 10) {
					current = 'f';
				} else if (h > 5 && a > 10) {
					current = 'w';
				} else break;
			} else if (current == 'w' && h > 5 && a > 10) {
				survive += 1;
				h -= 5;
				a -= 10;
				current = 'a';
			} else if (current == 'f' && h > 20) {
				survive += 1;
				h -= 20;
				a += 10;
				current = 'a';
			}
		}

		return survive;
	}

}
