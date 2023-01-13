class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        //Step 1 get the finish list
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) if(!visited[i]) DFS(i, adj, visited, stack);
        
        //Step 2 reverse all edges
        ArrayList<ArrayList<Integer>> radj = new ArrayList<>();
        for(int i=0;i<V;i++) radj.add(new ArrayList<Integer>());
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                radj.get(adj.get(i).get(j)).add(i);
            }
        }
        
        //Step 3 DFS
        int count = 0;
        boolean[] rvisited = new boolean[V];
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!rvisited[node]){
                count++;
                rDFS(node, radj, rvisited);
            }
        }
        return count;
    }
    public void rDFS(int node, ArrayList<ArrayList<Integer>> radj, boolean[] visited){
        visited[node] = true;
        for(int i=0;i<radj.get(node).size();i++){
            if(!visited[radj.get(node).get(i)]) rDFS(radj.get(node).get(i), radj, visited);
        }
    }
    public void DFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(int i=0;i<adj.get(node).size();i++){
            if(!visited[adj.get(node).get(i)]) DFS(adj.get(node).get(i), adj, visited, stack);
        }
        stack.push(node);
    }
}
