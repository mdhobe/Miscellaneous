class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int smallestnumber = 201;
        for(int i=0;i<strs.length;i++){
            if(smallestnumber > strs[i].length()){
                smallestnumber = strs[i].length();
            }
        }
        
        String ans = "";
        String str = strs[0];
        for(int i=0;i<smallestnumber;i++){
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i) != str.charAt(i)){
                    return ans;
                }
                else if(strs[j].charAt(i) == str.charAt(i) && j == strs.length - 1){
                    ans += str.charAt(i);
                }
            }    
        }
        
        return ans;
    }
}
