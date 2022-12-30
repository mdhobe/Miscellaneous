class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> terminals = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        for(int i=0;i<n;i++) if(!visited[i]){
            detectCycle(i, graph, visited, visiting);
        }
        for(int i=0;i<n;i++) if(visited[i] && !visiting[i]) terminals.add(i);
        return terminals;
    }
    public boolean detectCycle(int curr, int[][] graph, boolean[] visited, boolean[] visiting){
        visited[curr] = true;
        visiting[curr] = true;
        for(int node : graph[curr]){
            if(visiting[node]) return true;
            else if(!visited[node]) if(detectCycle(node, graph, visited, visiting)) return true;
        }
        visiting[curr] = false;
        return false;
    }
}
