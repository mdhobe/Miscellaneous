class DistNode{
    int dist, node;
    DistNode(int d, int n){
        dist = d;
        node = n;
    }
}
class Solution {
    public static Comparator<DistNode> DistanceNodeComparator = new Comparator<DistNode>(){
        @Override
        public int compare(DistNode a, DistNode b){
            if(a.dist == b.dist) return a.node-b.node;
            return a.dist-b.dist;
        }
    };
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        //adj list
        List<List<DistNode>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<DistNode>());
        for(int[] e : edges){
            DistNode dn1 = new DistNode(e[2],e[0]);
            adj.get(e[1]).add(dn1);
            
            DistNode dn2 = new DistNode(e[2],e[1]);
            adj.get(e[0]).add(dn2);
        }
        
        //System.out.println(adj);
        
        PriorityQueue<DistNode> pq = new PriorityQueue<>(n+1, DistanceNodeComparator);
        pq.add(new DistNode(0,1));
        
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=0;i<n+1;i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            DistNode distnode = pq.poll();
            for(int i=0;i<adj.get(distnode.node).size();i++){
                DistNode newdistnode = adj.get(distnode.node).get(i);
                int distance = newdistnode.dist + distnode.dist;
                int nnew = newdistnode.node;
                if(distance < dist[nnew]){
                    pq.add(new DistNode(distance,nnew));
                    parent[nnew] = distnode.node;
                    dist[nnew] = distance;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int currnode = n;
        
        if(dist[currnode] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        while(currnode != 1){
            ans.add(currnode);
            currnode = parent[currnode];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
