//DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(dfs(i,visited,graph,-1)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int[] visited, int[][] graph, int color){
        for(int n : graph[node]){
            if(visited[n] == 0){
                visited[n] = color;
                if(dfs(n, visited, graph, (-1)*color)) return true;;
            }
            else if(visited[n] == visited[node]) return true;
        }
        return false;
    }
}
