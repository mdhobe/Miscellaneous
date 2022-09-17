class Solution {
    public String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
		ans.append('1');
		return countResult(n - 1, ans);
    }
    public String countResult(int n, StringBuilder ans) {
		if (n == 0) return ans.toString();
		ArrayList<ArrayList<Integer>> list = countNumbers(ans.toString());
		int length = list.size();
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < length; i++) {
			a.append(list.get(i).get(1));
			a.append(list.get(i).get(0));
		}
		return countResult(n - 1, a);
	}

	public ArrayList<ArrayList<Integer>> countNumbers(String str) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int length = str.length(), count = 1;
		for (int i = 1; i < length; i++) {
			if (str.charAt(i - 1) == str.charAt(i)) count++;
			else {
				ArrayList<Integer> d = new ArrayList<>();
				d.add(Character.getNumericValue(str.charAt(i - 1)));
				d.add(count);
				list.add(d);
				count = 1;
			}
		}
		ArrayList<Integer> c = new ArrayList<>();
		c.add(Character.getNumericValue(str.charAt(length - 1)));
		c.add(count);
		list.add(c);
		return list;
	}
}
