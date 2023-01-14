class Solution
{
    private int timer = 1;
    public void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] time, int[] low, int[] mark){
        visited[node] = true;
        time[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(!visited[it]){
                dfs(it, node, adj, visited, time, low, mark);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] >= time[node] && parent != -1) mark[node] = 1;
                child++;
            } else low[node] = Math.min(low[node], time[it]);
        }
        if(child > 1 && parent == -1) mark[node] = 1;
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        boolean[] visited = new boolean[V];
        int[] time = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        for(int i=0;i<V;i++){
            if(!visited[i]) dfs(i, -1, adj, visited, time, low, mark);
        }
        ArrayList<Integer> articulation = new ArrayList<>();
        for(int i=0;i<V;i++) if(mark[i] == 1) articulation.add(i);
        if(articulation.size() == 0) articulation.add(-1);
        return articulation;
    }
}
