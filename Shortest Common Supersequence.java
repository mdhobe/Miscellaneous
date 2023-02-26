class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1, str2);
    }

    public String lcs(String str1, String str2){
        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int index1 = l1;
        int index2 = l2;
        while(index1 > 0 && index2 > 0){
            if(dp[index1][index2] == Math.max(dp[index1-1][index2], dp[index1][index2-1])){
                if(dp[index1][index2] == dp[index1][index2-1]){
                    ans.append(str2.charAt(index2-1));
                    index2 = index2 - 1;
                } else {
                    ans.append(str1.charAt(index1-1));
                    index1 = index1 - 1;
                }
            } else {
                ans.append(str1.charAt(index1-1));
                index1 = index1 - 1;
                index2 = index2 - 1;
            }
        }

        while(index1 > 0){
            ans.append(str1.charAt(index1-1));
            index1--;
        }
        while(index2 > 0){
            ans.append(str2.charAt(index2-1));
            index2--;
        }
        
        return ans.reverse().toString();
    }
}
