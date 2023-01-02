//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++) adj.put(i, new ArrayList<>());
        for(int[] entry : prerequisites){
            int course = entry[0];
            int pre = entry[1];
            adj.get(pre).add(course);
        }
        
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(Integer a : adj.get(i)){
                indegree[a]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) queue.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for(Integer a:adj.get(node)){
                indegree[a]--;
                if(indegree[a] == 0) queue.add(a);
            }
        }
        return ans.size() == numCourses;
    }
}
