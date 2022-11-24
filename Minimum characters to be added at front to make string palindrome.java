class Solution {
    public static int minChar(String str) {
       //Write your code here
       int ans = 0, length = str.length();
       int i=0,j=length-1;
       
       while(i<j){
           if(str.charAt(i) == str.charAt(j)){
               i++;
               j--;
           } else {
               ans = length - j;
               i=0;
               while(str.charAt(i) == str.charAt(j)){
                   ans--;
                   i++;
               }
               j--;
           }
       }
       
       return ans;
    }
}

// class Solution {
//     public static int minChar(String str) {
//        //Write your code here
//        int ans = 0;
//         for(int i=str.length()-1;i>=0;i--){
//             if(isPalindrome(str, i)) break;
//             else ans++;
//         }
//         return ans;
//     }
//     public static boolean isPalindrome(String A, int end){
//         for(int i=0;i<=end;i++){
//             if(A.charAt(i) != A.charAt(end-i)) return false;
//         }
//         return true;
//     }
// }
