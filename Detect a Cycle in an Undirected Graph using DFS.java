//DFS Solution
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++) adj.put(i, new ArrayList<>());
        for(int[] entry : prerequisites){
            int course = entry[0];
            int pre = entry[1];
            adj.get(pre).add(course);
        }
        if(isCycle(adj)) return false;
        return true;
    }
    public boolean isCycle(HashMap<Integer, ArrayList<Integer>> adj){
        Set<Integer> all = new HashSet<>();
        all.addAll(adj.keySet());

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        while(!all.isEmpty()){
            int curr = all.iterator().next();
            if(isCycle(curr, all, adj, visiting, visited)) return true;
        }
        return false;
    }
    public boolean isCycle(int curr, Set<Integer> all, HashMap<Integer, ArrayList<Integer>> adj, Set<Integer> visiting, Set<Integer> visited){
        all.remove(curr);
        visiting.add(curr);

        for(var node : adj.get(curr)){
            if(visited.contains(node)) continue;
            if(visiting.contains(node)) return true;
            if(isCycle(node, all, adj, visiting, visited)) return true;
        }

        visiting.remove(curr);
        visited.add(curr);

        return false;
    }
}
