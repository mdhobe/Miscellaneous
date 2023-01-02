class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,stack);
            }
        }
        int[] ans = new int[V];
        for(int i=0;i<V;i++) ans[i] = stack.pop();
        return ans;
    }
    
    static void dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean[] visited, Stack<Integer> stack){
        visited[v] = true;
        for(Integer a : adj.get(v)){
            if(!visited[a]){
                dfs(a, adj, visited, stack);
            }
        }
        stack.push(v);
    }
}
