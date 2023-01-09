class TimeNode{
    int time, node;
    TimeNode(int time, int node){
        this.time = time;
        this.node = node;
    }
}
class Solution {
    public Comparator<TimeNode> TimeNodeComparator = new Comparator<TimeNode>(){
        @Override
        public int compare(TimeNode a, TimeNode b){
            return a.time - b.time;
        }
    };
    public int countPaths(int n, int[][] roads) {
        //create adj
        ArrayList<ArrayList<TimeNode>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<TimeNode>());
        for(int[] r : roads){
            adj.get(r[0]).add(new TimeNode(r[2], r[1]));
            adj.get(r[1]).add(new TimeNode(r[2], r[0]));
        }

        //create pq
        PriorityQueue<TimeNode> pq = new PriorityQueue<>(1, TimeNodeComparator);
        pq.add(new TimeNode(0, 0));
        int[] times = new int[n];
        int[] ways = new int[n];
        for(int i=0;i<n;i++){
            times[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        times[0] = 0;
        ways[0] = 1;
        
        //dijkastra algo
        int mod = (int) 1e9+7;
        while(!pq.isEmpty()){
            TimeNode tn = pq.poll();
            for(int i=0;i<adj.get(tn.node).size();i++){
                TimeNode ttn = adj.get(tn.node).get(i);
                int ntime = tn.time + ttn.time;
                if(ntime == times[ttn.node]){
                    //coding
                    ways[ttn.node] = (ways[ttn.node] + ways[tn.node])%mod;
                }
                if(times[ttn.node] > ntime){
                    times[ttn.node] = ntime;
                    ways[ttn.node] = ways[tn.node];
                    pq.add(new TimeNode(ntime, ttn.node));
                }
            }
        }
        return (int) (ways[n-1]%mod);
    }
}
