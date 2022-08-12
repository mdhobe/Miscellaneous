class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<List<Integer>> arr = new ArrayList<>();

		for (int[] item : intervals) {
			arr.add(Arrays.asList(new Integer[] {item[0], item[1]}));
		}

		Collections.sort(arr, (a, b)-> {
			if (a.get(0) - b.get(0) == 0) {
				return a.get(1) - b.get(1);
			} else {
				return a.get(0) - b.get(0);
			}
		});

		System.out.println(arr);

		ArrayList < List < Integer >> merged = new ArrayList < > ();

		for (int i = 0; i < arr.size(); i++) {
			if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < arr.get(i).get(0)) {
				ArrayList < Integer > v = new ArrayList < > ();
				v.add(arr.get(i).get(0));
				v.add(arr.get(i).get(1));

				merged.add(v);
			} else {

				merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), arr.get(i).get(1)));
			}
		}

		int[][] ans1 = new int[merged.size()][2];
		for (int i = 0; i < merged.size(); i++) {
			ans1[i][0] = merged.get(i).get(0);
			ans1[i][1] = merged.get(i).get(1);
		}
        
        return ans1;
    }
}
