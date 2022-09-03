class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<ArrayList<Integer>> stringLengthComparator = new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> s1, ArrayList<Integer> s2) {
                if(s1.get(1) == s2.get(1)){
                    return s1.get(0) - s2.get(0);
                }
                return s1.get(1) - s2.get(1);
            }
        };
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(stringLengthComparator);
        for(int i=0;i<mat.length;i++){
            ArrayList<Integer> a = new ArrayList<>();
            a.add(i);
            int c = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1) c++;
                else break;
            }
            a.add(c);
            pq.add(new ArrayList(a));
        }
        
        System.out.println(pq);
        
        int[] ans = new int[k];
        for(int i=0;i<ans.length;i++){
            ans[i] = pq.poll().get(0);
        }
        return ans;
    }
}
