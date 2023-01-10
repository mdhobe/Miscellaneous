class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //distance matrix
        int[][] distances = new int[n][n];
        // MAX VALUE
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) distances[i][j] = Integer.MAX_VALUE;
        // Same node dist 0
        for(int i=0;i<n;i++) distances[i][i] = 0;
        // matrix filling
        for(int[] e : edges){
            distances[e[1]][e[0]] = e[2];
            distances[e[0]][e[1]] = e[2];
        }
        //Floyd Warshall Algo
        for(int k=0;k<n;k++){
            // via k
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE){
                        distances[i][j] = Math.min(distances[i][j], distances[i][k]+distances[k][j]);
                    }
                }
            }
        }
        //min number of cities
        int ans = Integer.MAX_VALUE;
        int node = 0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i != j && distances[i][j] <= distanceThreshold) count++;
            }
            if(ans >= count){
                node = i;
                ans = Math.min(ans, count);
            }
        }
        return node;
    }
}
