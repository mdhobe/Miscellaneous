import java.io.*;
import java.util.*;

public class B {
	public static char[] directions = { 'D', 'L', 'R', 'U' };
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] maze =  {
			{1, 0, 0, 0, 0},
			{1, 1, 0, 1, 0},
			{0, 1, 0, 0, 0},
			{1, 1, 1, 1, 1},
			{1, 0, 0, 1, 1}
		};
		int[][] path = new int[n][n];
		path[0][0] = 1;
		StringBuilder ans = new StringBuilder("");
		mazes(maze, path, n, 0, 0, ans);
	}

	public static void mazes(int[][] maze, int[][] path, int n, int col, int row, StringBuilder ans) {
		if (row == n - 1 && col == n - 1) {
			System.out.println(ans);
			return;
		}
		for (char dir : directions) {
			if (row != n - 1 && dir == 'D' && maze[row + 1][col] == 1 && path[row + 1][col] == 0) {
				path[row + 1][col] = 1;
				ans.append('D');
				mazes(maze, path, n, col, row + 1, ans);
				ans.deleteCharAt(ans.length() - 1);
				path[row + 1][col] = 0;
			} else if (col != 0 && dir == 'L' && maze[row][col - 1] == 1 && path[row][col - 1] == 0) {
				path[row][col - 1] = 1;
				ans.append('L');
				mazes(maze, path, n, col - 1, row, ans);
				ans.deleteCharAt(ans.length() - 1);
				path[row][col - 1] = 0;
			} else if (col != n - 1 && dir == 'R' && maze[row][col + 1] == 1 && path[row][col + 1] == 0) {
				path[row][col + 1] = 1;
				ans.append('R');
				mazes(maze, path, n, col + 1, row, ans);
				ans.deleteCharAt(ans.length() - 1);
				path[row][col + 1] = 0;
			} else if (row != 0 && dir == 'U' && maze[row - 1][col] == 1 && path[row - 1][col] == 0) {
				path[row - 1][col] = 1;
				ans.append('U');
				mazes(maze, path, n, col, row - 1, ans);
				ans.deleteCharAt(ans.length() - 1);
				path[row - 1][col] = 0;
			}
		}
	}
}
