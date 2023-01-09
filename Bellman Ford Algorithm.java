class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        for(int i=0;i<V;i++) dist[i] = (int) 1e8;
        dist[S] = 0;
        
        for(int i=0;i<V-1;i++){
            for(int j=0;j<edges.size();j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int w = edges.get(j).get(2);
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        //for negative cycle
        for(int j=0;j<edges.size();j++){
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int w = edges.get(j).get(2);
            if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                int[] temp = {-1};
                return temp;
            }
        }
        
        return dist;
    }
}
