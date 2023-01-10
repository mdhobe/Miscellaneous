class Cell{
    int node, weight;
    Cell(int n, int w){
        node = n;
        weight = w;
    }
}
class Solution{
    static Comparator<Cell> nodeComparator = new Comparator<Cell>(){
        @Override
        public int compare(Cell a, Cell b){
            if(a.weight == b.weight) return a.node - b.node;
            return a.weight - b.weight;
        }
    };
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    //adj list
	    ArrayList<ArrayList<Cell>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++) adj.add(new ArrayList<Cell>());
	    for(int[] e : edges){ 
	        adj.get(e[0]).add(new Cell(e[1], e[2]));
	        adj.get(e[1]).add(new Cell(e[0], e[2]));
	    }
	    
	    // inintiate values
	    boolean[] visited = new boolean[V];
	    PriorityQueue<Cell> pq = new PriorityQueue<>(1, nodeComparator);
	    pq.add(new Cell(0, 0));
	    int weight = 0;
	    while(!pq.isEmpty()){
	        Cell node = pq.poll();
	        if(!visited[node.node]){
	            visited[node.node] = true;
	            weight += node.weight;
	            for(int i=0;i<adj.get(node.node).size();i++){
	                Cell n = adj.get(node.node).get(i);
	                pq.add(new Cell(n.node, n.weight));
	            }
	        }
	    }
	    return weight;
	}
}
