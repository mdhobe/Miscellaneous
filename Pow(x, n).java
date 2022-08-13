class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
		long nn = n;
		if (nn < 0) nn = (-1) * nn;

		while (nn > 0) {
			if (nn % 2 == 1) {
				ans *= x;
				nn -= 1;
			} else {
				x *= x;
				nn /= 2;
			}
		}

		if (n < 0) ans = 1 / ans;

		System.out.println(ans);
		return ans;
    }
}
