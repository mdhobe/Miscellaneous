class Solution {
    public int repeatedStringMatch(String a, String b) {
		StringBuilder fa = new StringBuilder(a);
		if (fa.length() >= b.length()) {
			if (isSubstring(fa.toString(), b)) return 1;
			fa.append(a);
			if (isSubstring(fa.toString(), b)) return 2;
			fa.append(a);
			if (isSubstring(fa.toString(), b)) return 3;
		} else {
			int ans = b.length() / a.length();
			for (int i = 0; i < ans - 1; i++) fa.append(a);
			if (b.length() % a.length() != 0){
                fa.append(a);
                ans++;
            }
			if (isSubstring(fa.toString(), b)) return ans;
			fa.append(a);
			if (isSubstring(fa.toString(), b)) return ans + 1;
		}
		return -1;
	}

	public boolean isSubstring(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			if (compare(i, a, b)) return true;
		}
		return false;
	}

	public boolean compare(int index, String a, String b) {
		if (a.length() - index >= b.length()) {
			for (int i = 0; i < b.length(); i++) {
				if (a.charAt(index + i) != b.charAt(i)) return false;
			}
		} else return false;
		return true;
	}

}
