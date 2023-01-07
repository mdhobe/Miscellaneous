class DistanceNode{
    int dist, x, y;
    DistanceNode(int d, int tx, int ty){
        dist = d;
        x = tx;
        y = ty;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //init distance and parent
        int[] directionx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] directiony = {-1, -1, 0, 1, 1, 1, 0, -1};
        int n = grid.length;

        //edge case
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] distance = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        int count = 0;
        boolean found = false;

        //define pq
        Queue<DistanceNode> pq = new LinkedList<>();
        pq.add(new DistanceNode(0, 0, 0));
        while(!pq.isEmpty() && !found){
            int size = pq.size();
            count++;
            System.out.println(size);
            while(size-->0){
                DistanceNode node = pq.poll();
                for(int i=0;i<8;i++){
                    int f_x = node.x + directionx[i];
                    int f_y = node.y + directiony[i];
                    try {
                        if(grid[f_x][f_y] == 0 && distance[node.x][node.y] + 1 < distance[f_x][f_y]){
                            distance[f_x][f_y] = distance[node.x][node.y] + 1;
                            pq.add(new DistanceNode(distance[f_x][f_y], f_x, f_y));
                        }
                        if(grid[f_x][f_y] == 0 && f_x == n-1 && f_y == n-1){
                            if(!found) count++;
                            found = true;
                            break;
                        }
                    }
                    catch(Exception e) {
                        continue;
                    }
                }
            }
        }

        if(distance[n-1][n-1] == Integer.MAX_VALUE) return -1;
        return count;
    }
}
