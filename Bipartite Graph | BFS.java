//BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                if(bfs(i,visited,graph)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int node, int[] visited, int[][] graph){
        int color = 1;
        visited[node] = color;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            color *= -1;
            for(int i=0;i<size;i++){
                int curr = queue.poll();
                for(int n : graph[curr]){
                    if(visited[n] == 0){
                        visited[n] = color;
                        queue.add(n);
                    } else if(visited[n] == (-1)*color) return true;
                }
            }
        }
        return false;
    }
}
