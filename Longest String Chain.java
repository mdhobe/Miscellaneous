class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparing(s->s.length()));
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(compare(words[i], words[j]) && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 1;
        for(int i=0;i<n;i++) max = Math.max(max, dp[i]);
        return max;
    }

    public boolean compare(String s1, String s2){
        if(s1.length() != s2.length()+1) return false;
        int first = 0, second = 0;
        while(first < s1.length()){
            if(second < s2.length() && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            } else first++;
        }
        if(first == s1.length() && second == s2.length()) return true;
        return false;
    }
}
