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
		int[] index = {6, 3, 4, 2, 5, 8, 1, 7}, deadline =  {2, 6, 6, 5, 4, 2, 4, 2}, profit = {80, 70, 65, 60, 25, 22, 20, 10};

		ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> job = new ArrayList<>();
			job.add(index[i]);
			job.add(deadline[i]);
			job.add(profit[i]);
			jobs.add(new ArrayList(job));
		}

		//decending order
		Collections.sort(jobs, (a, b)-> {
			if (a.get(2) - b.get(2) == 0) {
				return -1 * (a.get(1) - b.get(1));
			} else {
				return -1 * (a.get(2) - b.get(2));
			}
		});

		JobScheduling(jobs);
	}

	public int getMaxDeadline(ArrayList<ArrayList<Integer>> jobs) {
		int max = 0;
		for (int i = 0; i < jobs.size(); i++) {
			max = Math.max(max, jobs.get(i).get(1));
		}
		return max;
	}

	public void JobScheduling(ArrayList<ArrayList<Integer>> jobs) {
		int maxDeadline = getMaxDeadline(jobs);
		int[] track = new int[maxDeadline];

		int profit = 0;
		for (int i = 0; i < jobs.size(); i++) {
			if (track[jobs.get(i).get(1) - 1] == 0) {
				profit += jobs.get(i).get(2);
				track[jobs.get(i).get(1) - 1] = 1;
			} else {
				int findIndex = jobs.get(i).get(1) - 1;
				while (findIndex >= 0 && track[findIndex] == 1) {
					findIndex--;
				}
				if (findIndex > -1) {
					track[findIndex] = 1;
					profit += jobs.get(i).get(2);
				}
			}
		}

		int job = 0;
		for (int i = 0; i < maxDeadline; i++) if (track[i] != 0) job++;;

		System.out.println(job + " " + profit);
	}

	public void print(int[] track) {
		for (int i : track) System.out.print(track[i] + " ");
		System.out.println();
	}
}
