class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] visited = new int[cities];
        int ans = 0;
        for(int j=0;j<cities;j++){
            if(visited[j] == 0){
                ans++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    visited[node] = 1;
                    for(int i=0;i<cities;i++){
                        if(visited[i] == 0 && isConnected[node][i] == 1){
                            queue.add(i);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
