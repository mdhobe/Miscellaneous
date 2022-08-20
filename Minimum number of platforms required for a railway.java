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
		String[] start = {"0900", "0945", "0955", "1100", "1500", "1800"}, end =  {"0920", "1200", "1130", "1150", "1900", "2000"};

		System.out.println(maxPlatforms(Arrays.sort(start), Arrays.sort(end)));
	}

// 	public int maxPlatforms(String[] start, String[] end) {
// 		int ans = 0;
// 		for (int i = 0; i < start.length; i++) {
// 			int count = 0;
// 			for (int j = 0; j < end.length; j++) {
// 				if (start[j].compareTo(start[i]) >= 0 && start[j].compareTo(end[i]) <= 0) count++;
// 				else if (end[j].compareTo(start[i]) >= 0 && end[j].compareTo(end[i]) <= 0) count++;
// 			}
// 			ans = Math.max(count, ans);
// 		}
// 		return ans;
// 	}
  
  public int maxPlatforms(String[] start, String[] end) {
		int ans = 0, ps = 0, pe = 0, p = 0;

		while (ps < start.length) {
			if (start[ps].compareTo(end[pe]) <= 0) {
				ans++;
				p = Math.max(p, ans);
				ps++;
			} else if (start[ps].compareTo(end[pe]) >= 0) {
				ans--;
				p = Math.max(p, ans);
				pe++;
			}
		}

		return p;
	}
  

}
