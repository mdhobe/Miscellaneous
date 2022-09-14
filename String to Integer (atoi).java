class Solution {
    public int myAtoi(String s) {
        int i = 0, num = 0;
        boolean neg = false;
        while(s.length()>i && s.charAt(i)==' ') i++;
        if(s.length()>i && s.charAt(i)=='+') i++;
         else if(s.length()>i && s.charAt(i)=='-'){
            i++;
            neg=true;
        }
        while(s.length()>i&&Character.isDigit(s.charAt(i))){
            int nu = s.charAt(i)-'0';
            if(num>(Integer.MAX_VALUE-nu)/10){
                if(neg) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            num= (num*10)+nu;
            i++;
        }
        if(num==0) return 0;
        if(neg) return -1*num;
        else return num;
    }
}
