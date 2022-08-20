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
		int[] start = {1, 3, 0, 5, 8, 5}, end =  {2, 4, 5, 7, 9, 9};
		ArrayList<ArrayList<Integer>> myarray = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			ArrayList<Integer> meet = new ArrayList<>();
			meet.add(start[i]);
			meet.add(end[i]);
			meet.add(i + 1);
			myarray.add(new ArrayList(meet));
		}

		Collections.sort(myarray, (a, b)-> {
			if (a.get(1) - b.get(1) == 0) {
				return a.get(2) - b.get(2);
			} else {
				return a.get(1) - b.get(1);
			}
		});

		maxMeetings(myarray);
	}

	public void maxMeetings(ArrayList<ArrayList<Integer>> myarray) {
		ArrayList<Integer> ans = new ArrayList<>();
		int prev_end = myarray.get(0).get(1);
		ans.add(myarray.get(0).get(2));

		for (int i = 1; i < myarray.size(); i++) {
			if (myarray.get(i).get(0) > prev_end) {
				ans.add(myarray.get(i).get(2));
				prev_end = myarray.get(i).get(1);
			}
		}

		Collections.sort(ans);
		System.out.println(ans);
	}

}
