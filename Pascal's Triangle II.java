class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
		ans.add(1);
		if (rowIndex == 0) return ans;
		ans.add(1);
		if (rowIndex == 1) return ans;

		for (int i = 1; i < rowIndex; i++) {
			ans.add(1);
			int n = ans.size();
			for (int j = n - 1; j >= 1; j--) {
				ans.set(j, ans.get(j) + ans.get(j - 1));
			}
			ans.remove(ans.size() - 1);
			ans.add(1);
		}

		return ans;
    }
}
