class DistanceStopsFrom{
    int price, stops, from;
    DistanceStopsFrom(int p, int s, int f){
        price = p;
        stops = s;
        from = f;
    }
}
class WeightNode{
    int node, weight;
    WeightNode(int n, int w){
        node = n;
        weight = w;
    }
}
class Solution {
    public Comparator<DistanceStopsFrom> DistanceStopsFromComparator = new Comparator<DistanceStopsFrom>(){
         @Override
         public int compare(DistanceStopsFrom a, DistanceStopsFrom b){
             return a.stops - b.stops;
         }
     };
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //create adj list
        ArrayList<ArrayList<WeightNode>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<WeightNode>());
        for(int[] node : flights) adj.get(node[0]).add(new WeightNode(node[1], node[2]));
        //System.out.println(adj);

        //create pq and prices array
        PriorityQueue<DistanceStopsFrom> dsf = new PriorityQueue<>(1, DistanceStopsFromComparator);
        dsf.add(new DistanceStopsFrom(0, 0, src));
        int ans = Integer.MAX_VALUE;
        int[] prices = new int[n];
        for(int i=0;i<n;i++) prices[i] = Integer.MAX_VALUE;
        prices[src] = 0;

        //compute
        while(!dsf.isEmpty()){
            DistanceStopsFrom node = dsf.poll();
            for(int i=0;i<adj.get(node.from).size();i++){
                WeightNode wn = adj.get(node.from).get(i);
                int price = node.price+wn.weight;
                if(wn.node == dst && node.stops <= k){
                    ans = Math.min(ans, price);
                }
                if(prices[wn.node] > price){
                    prices[wn.node] = price;
                    int stops = node.stops + 1;
                    dsf.add(new DistanceStopsFrom(price, stops, wn.node));
                }
            }
        }

        if(ans == Integer.MAX_VALUE) return -1;

        return ans;
    }
}
