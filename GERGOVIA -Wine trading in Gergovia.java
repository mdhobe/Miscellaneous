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
		int[] a = { 5, -4, 1, -3, 1};

		gergovia(a);
	}

	public void gergovia(int[] nums) {
		int buyerp = 0, sellerp = 0, ans = 0;

		ArrayList<ArrayList<Integer>> buyers = new ArrayList<>();
		ArrayList<ArrayList<Integer>> sellers = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ArrayList<Integer> item = new ArrayList<>();
				item.add(nums[i]);
				item.add(i);
				buyers.add(item);
			} else if (nums[i] < 0) {
				ArrayList<Integer> item = new ArrayList<>();
				item.add(nums[i]);
				item.add(i);
				sellers.add(item);
			}
		}

		while (buyerp < buyers.size() && sellerp < sellers.size()) {
			int min = Math.min(buyers.get(buyerp).get(0), -1 * sellers.get(sellerp).get(0));
			buyers.get(buyerp).set(0, buyers.get(buyerp).get(0) - min);
			sellers.get(sellerp).set(0, sellers.get(sellerp).get(0) + min);
			int diff = Math.abs(buyers.get(buyerp).get(1) - sellers.get(sellerp).get(1));
			ans += diff * min;
			if (buyers.get(buyerp).get(0) == 0) buyerp++;
			if (sellers.get(sellerp).get(0) == 0) sellerp++;
		}

		System.out.println(ans);
	}

}
