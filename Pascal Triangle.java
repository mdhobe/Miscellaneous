class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> series = new ArrayList<>();
			series.add(1);

			if (i == 1) {
				series.add(1);
			} else if (i > 1) {
				for (int j = 1; j < pascal.get(i - 1).size(); j++) {
					series.add(pascal.get(i - 1).get(j) + pascal.get(i - 1).get(j - 1));
				}
				series.add(1);
			}

			pascal.add(new ArrayList(series));
		}
        
        return pascal;
    }
}
