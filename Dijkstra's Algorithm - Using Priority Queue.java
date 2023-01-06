class DistNode{
    int dist, node;
    DistNode(int d, int n){
        dist = d;
        node = n;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    public static Comparator<DistNode> DistanceNodeCompare = new Comparator<DistNode>(){

        @Override
        public int compare(DistNode a, DistNode b)
        {
            //Your Own Logic
            if(a.dist == b.dist) return a.node - b.node;
            else return a.dist-b.dist;
        }

    };
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        // Define PQ
        PriorityQueue<DistNode> pq = new PriorityQueue<>(V, DistanceNodeCompare);
        
        // Define initial distance
        int[] distance = new int[V];
        for(int i=0;i<V;i++) distance[i] = Integer.MAX_VALUE;
        distance[S] = 0;
        
        // Dijkstra algo
        pq.add(new DistNode(0, S));
        while(!pq.isEmpty()){
            DistNode distnode = pq.poll();
            for(int i=0;i<adj.get(distnode.node).size();i++){
                int finaldist = distance[distnode.node] + adj.get(distnode.node).get(i).get(1);
                if(distance[adj.get(distnode.node).get(i).get(0)] > finaldist){
                    distance[adj.get(distnode.node).get(i).get(0)] = finaldist;
                    pq.add(new DistNode(finaldist, adj.get(distnode.node).get(i).get(0)));
                }
            }
        }
        return distance;
    }
}
