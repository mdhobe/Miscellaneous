// without using extra space
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
// 		int[] a = { -1000, -1000, -1000, 1000, 1000, 1000};

// 		gergovia(a);
// 	}

// 	public void gergovia(int[] a) {
// 		int buyer = 0, seller = 0;
// 		int ans = 0;

// 		while (buyer < a.length || seller < a.length) {

// 			if (buyer < a.length && a[buyer] <= 0) {
// 				buyer++;
// 				continue;
// 			} else if (seller < a.length && a[seller] >= 0) {
// 				seller++;
// 				continue;
// 			}


// 			if (a[seller] + a[buyer] > 0) {
// 				ans += Math.abs(seller - buyer) * Math.min(-1 * a[seller], a[buyer]);
// 				a[buyer] = a[seller] + a[buyer];
// 				a[seller] = 0;
// 				seller++;
// 			} else if (a[seller] + a[buyer] < 0) {
// 				ans += Math.abs(seller - buyer) * Math.min(-1 * a[seller], a[buyer]);
// 				a[seller] = a[seller] + a[buyer];
// 				a[buyer] = 0;
// 				buyer++;
// 			} else if (a[seller] + a[buyer] == 0) {
// 				ans += Math.abs(seller - buyer) * Math.min(-1 * a[seller], a[buyer]);
// 				a[buyer] = 0;
// 				a[seller] = 0;
// 				buyer++;
// 				seller++;
// 			}
// 		}

// 		System.out.println(ans);
// 	}
// }

//using extra space
