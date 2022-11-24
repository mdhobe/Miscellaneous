class Solution {
    public int strStr(String haystack, String needle) {
        int[] prefix = prefixArray(needle);
        int ans = -1;
        int i=0,j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                if(j!=0) j = prefix[j-1];
                else i++;
            }
            if(j == needle.length()){
                ans = i - needle.length();
                break;
            }
        }
        return ans;
    }
    
    public int[] prefixArray(String s){
        int length = s.length();
        int[] prefix = new int[length];
        for(int i=1;i<length;i++){
            int j = prefix[i-1];
            while(j>0 && s.charAt(i) != s.charAt(j)) j=prefix[j-1];
            if(s.charAt(j) == s.charAt(i))j++;
            prefix[i]=j;
        }
        return prefix;
    }
}
