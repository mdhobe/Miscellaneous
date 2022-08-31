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
		int arr[] = {3, 2, 1, 5, 6, 4};
		int k = 2;
		System.out.println(findKthLargest(arr, k));
	}

// 	public int findKthLargest(int[] nums, int k) {
// 		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

// 		for (int num : nums)pq.add(num);

// 		int ans = 0;
// 		while (k-- > 0) {
// 			ans = pq.peek();
// 			pq.poll();
// 		}
// 		return ans;
// 	}
  
  public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			pq.add(nums[i]);
		}

		for (int i = k; i < nums.length; i++) {
			if (pq.peek() < nums[i]) {
				pq.poll();
				pq.add(nums[i]);
			}
		}

		return pq.peek();
    }

}
