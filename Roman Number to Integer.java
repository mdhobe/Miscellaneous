class Solution {
    public int romanToInt(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') ans -= 1;
			else if (i != s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') ans -= 1;
			else if (i != s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') ans -= 10;
			else if (i != s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') ans -= 10;
			else if (i != s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') ans -= 100;
			else if (i != s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') ans -= 100;
			else {
				ans += getInteger(s.charAt(i));
			}
		}
		return ans;
	}

	public int getInteger(char a) {
		if (a == 'M') return 1000;
		else if (a == 'D') return 500;
		else if (a == 'C') return 100;
		else if (a == 'L') return 50;
		else if (a == 'X') return 10;
		else if (a == 'V') return 5;
		else if (a == 'I') return 1;
		return 0;
	}
}
