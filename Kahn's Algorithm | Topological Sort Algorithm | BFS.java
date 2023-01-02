class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree = new int[V];
        for(ArrayList<Integer> ad : adj){
            for(Integer a : ad){
                indegree[a]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for(int index : adj.get(node)){
                indegree[index]--;
                if(indegree[index]==0) queue.add(index);
            }
        }
        int[] answer = new int[V];
        for(int i=0;i<V;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
