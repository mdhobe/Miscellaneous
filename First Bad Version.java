/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low = 1, high = n;
        while(low <= high){
            long mid = (low+high) >> 1;
            if(isBadVersion((int) mid) && !isBadVersion((int) mid-1)){
                return (int) mid;
            } else if(!isBadVersion((int) mid) && !isBadVersion((int) mid-1)){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}
