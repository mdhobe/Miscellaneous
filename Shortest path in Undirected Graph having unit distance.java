class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        //adj list
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++) adj.put(i, new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        //initilization distance
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
        
        //finding distance
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer a : adj.get(node)){
                if(dist[node]+1 < dist[a]){
                    dist[a] = dist[node]+1;
                    queue.add(a);
                }
            }
        }
        
        //non reaching dist
        for(int i=0;i<n;i++) if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        return dist;
    }
}
