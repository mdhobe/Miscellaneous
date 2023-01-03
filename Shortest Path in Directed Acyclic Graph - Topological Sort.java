class Pair{
    int node, dist;
    Pair(int n, int d){
        node = n;
        dist = d;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Create Adj List
		HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
		for(int i=0;i<N;i++) adj.put(i, new ArrayList<Pair>());
		for(int i=0;i<M;i++) adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		
		//topology sort
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N];
		dfs(0,adj,visited,stack);
		
		//Calculate Distance
		int[] distance = new int[N];
		for(int i=0;i<N;i++) distance[i] = Integer.MAX_VALUE;
		distance[0] = 0;
		
		while(!stack.isEmpty()){
		    Integer node = stack.pop();
		    for(Pair p : adj.get(node)){
		        distance[p.node] = Math.min(distance[p.node], p.dist+distance[node]);
		    }
		}
		
		for(int i=0;i<N;i++) if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
		
		return distance;
	}
	
	public void dfs(int node, HashMap<Integer, ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack){
	    visited[node] = true;
	    for(Pair p : adj.get(node)){
	        int cell = p.node;
	        if(!visited[cell]) dfs(cell, adj, visited, stack);
	    }
	    stack.push(node);
	}
}
