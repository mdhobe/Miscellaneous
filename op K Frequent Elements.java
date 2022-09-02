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
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;

		topKFrequent(nums, k);
	}

	public void topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> myhash = new HashMap<>();
		for (int num : nums) {
			if (myhash.containsKey(num)) {
				int c = myhash.get(num);
				myhash.put(num, ++c);
			} else {
				myhash.put(num, 1);
			}
		}


		PriorityQueue<ArrayList<Integer>> counts = new PriorityQueue<>((a, b)->b.get(1) - a.get(1));
		for ( Map.Entry<Integer, Integer> entry : myhash.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(num);
			temp.add(count);
			counts.add(new ArrayList(temp));
		}

		int i = 0;
		int[] ans = new int[k];

		while (i < k) {
			ans[i] = counts.peek().get(0);
			counts.poll();
			i++;
		}

		System.out.println(ans);
	}
}
