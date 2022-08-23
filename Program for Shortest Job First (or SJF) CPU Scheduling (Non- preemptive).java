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
		int[] process = { 1, 2, 3, 4, 5}, burst = { 7, 3, 2, 10, 8}, arrival = {1, 3, 6, 7, 9};
		ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();

		for (int i = 0; i < process.length; i++) {
			ArrayList<Integer> job = new ArrayList();
			job.add(process[i]);
			job.add(burst[i]);
			job.add(arrival[i]);
			jobs.add(new ArrayList(job));
		}

		// Collections.sort(jobs, (a, b)-> {
		// 	if (a.get(2) - b.get(2) == 0) return a.get(1) - b.get(1);
		// 	return a.get(2) - b.get(2);
		// });

		sjf(jobs);
	}

	public void sjf(ArrayList<ArrayList<Integer>> jobs) {
		System.out.println(jobs);
		ArrayList<Integer> ans = new ArrayList<>();
		int currtime = 0;

		while (ans.size() < jobs.size()) {
			ArrayList<ArrayList<Integer>> available = isCurrentTime(jobs, currtime, ans);
			System.out.println(available);

			if (available.size() > 0) {
				currtime += available.get(0).get(1);
				ans.add(available.get(0).get(0));
			} else {
				currtime += 1;
			}
		}

		System.out.println(ans);
	}

	public ArrayList<ArrayList<Integer>> isCurrentTime(ArrayList<ArrayList<Integer>> jobs, int time, ArrayList<Integer> ans) {
		ArrayList<ArrayList<Integer>> available = new ArrayList<>();
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).get(2) <= time && !ans.contains(jobs.get(i).get(0) )) {
				ArrayList<Integer> job = new ArrayList();
				job.add(jobs.get(i).get(0));
				job.add(jobs.get(i).get(1));
				job.add(jobs.get(i).get(2));
				available.add(new ArrayList(job));
			}
		}
		Collections.sort(available, (a, b)-> {
			if (a.get(1) - b.get(1) == 0) return a.get(2) - b.get(2);
			return a.get(1) - b.get(1);
		});
		return available;
	}
}
