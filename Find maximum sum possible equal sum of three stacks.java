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
		int[] s1 = {3, 10}, s2 = {4, 5}, s3 = {2, 1};
		maxSum(s1, s2, s3);
	}

	public void maxSum(int[] s1, int[] s2, int[] s3) {
		int sum1 = 0, sum2 = 0, sum3 = 0;
		int sp1 = 0, sp2 = 0, sp3 = 0;

		for (int n : s1) sum1 += n;
		for (int n : s2) sum2 += n;
		for (int n : s3) sum3 += n;

		while (sum1 != sum2 || sum2 != sum3) {
			if (sum1 > sum2 || sum1 > sum3) {
				sum1 -= s1[sp1];
				sp1++;
			} else if (sum2 > sum1 || sum2 > sum3) {
				sum2 -= s2[sp2];
				sp2++;
			} else if (sum3 > sum1 || sum3 > sum2) {
				sum3 -= s3[sp3];
				sp3++;
			}
		}
		System.out.println(sum1 + " " + sum2 + " " + sum3);
		return sum1;
	}

}
