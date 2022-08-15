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
		int target = scan.nextInt();
		String str = "dfghawhdsn7yqe";
		System.out.println(lengthOfLongestSubstring(str));
	}

	// public int lengthOfLongestSubstring(String s) {
	// 	int max = 0;
	// 	int left = 0, right = 0;

	// 	HashSet<Character> set = new HashSet<>();

	// 	while (right < s.length()) {
	// 		if (set.contains(s.charAt(right))) {
	// 			while (set.contains(s.charAt(right))) {
	// 				set.remove(s.charAt(left));
	// 				left++;
	// 			}
	// 		} else {
	// 			max = Math.max(max, right - left + 1);
	// 			set.add(s.charAt(right));
	// 			right++;
	// 		}
	// 		System.out.println(left + " " + right);
	// 	}

	// 	return max;
	// }

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0, right = 0;

		HashMap<Character, Integer> hash = new HashMap<>();

		while (right < s.length()) {
			if (hash.containsKey(s.charAt(right))) {
				left = Math.max(hash.get(s.charAt(right)) + 1, right);
			}
			hash.put(s.charAt(right), right);
			max = Math.max(max, right - left + 1);
			right++;
		}

		return max;
	}

}
