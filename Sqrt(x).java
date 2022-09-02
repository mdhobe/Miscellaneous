class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x;
		while (low <= high) {
			long mid = (low + high) >> 1;
			if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
				return (int) mid;
			} else if (mid * mid < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
    }
}
