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
		int[] A = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
		int[] B = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
		int C = 10;
		ArrayList<Integer> a = new ArrayList<>();
		for (int num : A)a.add(num);
		ArrayList<Integer> b = new ArrayList<>();
		for (int num : B)b.add(num);

		solve(a, b, C);
	}

	public void solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
		int size = A.size();
		PriorityQueue<pair>pq = new PriorityQueue<>((a, b)->b.val - a.val);
		HashSet<Integer>hs = new HashSet<>();
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B, Collections.reverseOrder());

		ArrayList<Integer>ans = new ArrayList<>();
		pq.add(new pair(0, 0, A.get(0) + B.get(0) ));
		hs.add(0);
		while (C-- != 0) {
			pair pair1 = pq.poll();
			ans.add(pair1.val);
			int a, b;
			a = pair1.poia;
			b = pair1.poib;

			if ( b + 1 < size && !hs.contains( a * size + (b + 1) ) ) {
				hs.add( a * size + b + 1 );
				pq.add( new pair(a, b + 1, A.get(a) + B.get(b + 1) ) );
			}
			if ( a + 1 < size && !hs.contains( (a + 1) * size + b ) ) {
				hs.add( (a + 1) * size + b );
				pq.add( new pair(a + 1, b, A.get(a + 1) + B.get(b) ) );
			}

		}
		System.out.println(ans);
	}
}
class pair {
	int poia, poib, val;
	public pair(int a , int b , int sum) {
		poia = a;
		poib = b;
		val = sum;
	}
} 
