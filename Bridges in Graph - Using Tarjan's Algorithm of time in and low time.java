class Solution {
    int timer = 0;

    public void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] low, int[] time, List<List<Integer>> bridges){
        visited[node] = true;
        low[node] = time[node] = timer;
        timer++;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(!visited[it]){
                dfs(it, node, adj, visited, low, time, bridges);
                low[node] = Math.min(low[it], low[node]);
                if(time[node] < low[it]) bridges.add(Arrays.asList(it, node));
            } else low[node] = Math.min(low[it], low[node]);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //creating adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(List<Integer> conn : connections){
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }

        //init
        List<List<Integer>> bridges = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] low = new int[n];
        int[] time = new int[n];
        dfs(0, -1, adj, visited, low, time, bridges);
        return bridges;
    }
}
