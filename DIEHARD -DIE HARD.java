// Math & Code (Logic)
// import java.io.*;
// import java.util.*;

// public class C {
// 	public void main() {
// 		try {
// 			System.setIn(new FileInputStream("input.txt"));
// 			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
// 		} catch (Exception e) {
// 			System.err.println("Error");
// 		}

// 		Scanner scan = new Scanner(System.in);
// 		int h = scan.nextInt(), a = scan.nextInt();

// 		System.out.println(harddie(h, a));
// 	}

// 	public int harddie(int h, int a) {
// 		int survive = 0;
// 		char current = 'a';

// 		while (h > 0 && a > 0) {
// 			if (current == 'a') {
// 				survive += 1;
// 				h += 3;
// 				a += 2;
// 				if (h > 20 && a <= 10) {
// 					current = 'f';
// 				} else if (h > 5 && a > 10) {
// 					current = 'w';
// 				} else break;
// 			} else if (current == 'w' && h > 5 && a > 10) {
// 				survive += 1;
// 				h -= 5;
// 				a -= 10;
// 				current = 'a';
// 			} else if (current == 'f' && h > 20) {
// 				survive += 1;
// 				h -= 20;
// 				a += 10;
// 				current = 'a';
// 			}
// 		}

// 		return survive;
// 	}

// }


//Using DP
// import java.io.*;
// import java.util.*;

// public class C {
// 	public void main() {
// 		try {
// 			System.setIn(new FileInputStream("input.txt"));
// 			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
// 		} catch (Exception e) {
// 			System.err.println("Error");
// 		}

// 		Scanner scan = new Scanner(System.in);
// 		int h = scan.nextInt(), a = scan.nextInt();

// 		int ans = 0;

// 		int one = solve(h + 3, a + 2, 1), two = solve(h - 5, a - 10, 2), three = solve(h - 20, a + 5, 3);

// 		if (one >= two && one >= three) ans = one;
// 		else if (two >= one && two >= three) ans = two;
// 		else if (three >= one && three >= two) ans = three;

// 		System.out.println(ans);
// 	}

// 	public int solve(int h, int a, int c) {
// 		if (h <= 0 || a <= 0) return 0;

// 		int one = 0, two = 0, three = 0;

// 		if (c != 1) one = 1 + solve(h + 3, a + 2, 1);
// 		else if (c != 2) two = 1 + solve(h - 5, a - 10, 2);
// 		else if (c != 3) three = 1 + solve(h - 20, a + 5, 3);

// 		int ans = 0;
// 		if (one >= two && one >= three) ans = one;
// 		else if (two >= one && two >= three) ans = two;
// 		else if (three >= one && three >= two) ans = three;

// 		return ans;
// 	}

// }

//Using DP
import java.io.*;
import java.util.*;

public class C {
	int[][] dp = new int[1001][1001];

	public void main() {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt(), a = scan.nextInt();

		for (int i = 0; i <= 1000; i++) for (int j = 0; j <= 1000; j++) dp[i][j] = -1;

		int ans = 0;

		int one = solve(h + 3, a + 2, 1), two = solve(h - 5, a - 10, 2), three = solve(h - 20, a + 5, 3);

		if (one >= two && one >= three) ans = one;
		else if (two >= one && two >= three) ans = two;
		else if (three >= one && three >= two) ans = three;

		System.out.println(ans);
	}

	public int solve(int h, int a, int c) {
		if (h <= 0 || a <= 0) return 0;
		if (dp[h][a] != -1) return dp[h][a];

		int one = 0, two = 0, three = 0;

		if (c != 1) one = 1 + solve(h + 3, a + 2, 1);
		else if (c != 2) two = 1 + solve(h - 5, a - 10, 2);
		else if (c != 3) three = 1 + solve(h - 20, a + 5, 3);

		int ans = 0;
		if (one >= two && one >= three) ans = one;
		else if (two >= one && two >= three) ans = two;
		else if (three >= one && three >= two) ans = three;

		return ans;
	}

}
