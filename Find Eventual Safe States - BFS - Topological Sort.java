class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = graph.length;
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<Integer>());
        for(int i=0;i<n;i++) for(int j=0;j<graph[i].length;j++) adj.get(graph[i][j]).add(i);

        int[] indegree = new int[n];
        for(int i=0;i<n;i++) for(int a : adj.get(i)) indegree[a]++;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i] == 0) queue.add(i);

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for(int a:adj.get(node)){
                indegree[a]--;
                if(indegree[a] == 0) queue.add(a);
            }
        }

        Collections.sort(ans);
        
        return ans;
    }
}
