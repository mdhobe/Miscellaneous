// Memoization
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++) for(int j=0;j<4;j++) dp[i][j] = -1;
        return ninjaTraining(n-1, points, 3, dp);
    }

    public static int ninjaTraining(int index, int points[][], int prev, int[][] dp){
        if(index == 0){
            int max = 0;
            for(int i=0;i<3;i++){
                if(i != prev){
                    max = Math.max(points[index][i], max);
                }
            }
            return max;
        }

        if(dp[index][prev] != -1) return dp[index][prev];

        int maxNum = 0;
        for(int i=0;i<3;i++){
            if(i != prev){
                int point = points[index][i] + ninjaTraining(index-1,points,i, dp);
                maxNum = Math.max(point, maxNum);
            }
        }

        return dp[index][prev] = maxNum;
    }

}

//Tabulation
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];

        // base condition
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1],points[0][2]));

        //loop condition
        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[day][last] = 0;

                for(int task=0;task<3;task++){
                    if(task != last){
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day-1][task]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

}

//Space Optimization
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[2][4];

        // base condition
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][0],points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1],points[0][2]));

        //loop condition
        for(int day=1;day<n;day++){
            for(int last=0;last<4;last++){
                dp[1][last] = 0;

                for(int task=0;task<3;task++){
                    if(task != last){
                        dp[1][last] = Math.max(dp[1][last], points[day][task] + dp[0][task]);
                    }
                }
            }

            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
            dp[0][3] = dp[1][3];

            dp[1][0] = 0;
            dp[1][1] = 0;
            dp[1][2] = 0;
            dp[1][3] = 0;
        }

        return dp[0][3];
    }

}
