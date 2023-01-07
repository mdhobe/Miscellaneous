class DistanceNode{
    int dist, x, y;
    DistanceNode(int d, int tx, int ty){
        dist = d;
        x = tx;
        y = ty;
    }
}
class ParentNode{
    int x, y;
    ParentNode(int tx, int ty){
        x = tx;
        y = ty;
    }
}
class Solution {
    public Comparator<DistanceNode> DistanceNodeCompare = new Comparator<DistanceNode>(){
         @Override
         public int compare(DistanceNode a, DistanceNode b)
         {
            //Your Own Logic
            return a.dist-b.dist;
         }

     };
    public int shortestPathBinaryMatrix(int[][] grid) {
        //init distance and parent
        int[] directionx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] directiony = {-1, -1, 0, 1, 1, 1, 0, -1};
        int n = grid.length;

        //edge case
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] distance = new int[n][n];
        ParentNode[][] parent = new ParentNode[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                distance[i][j] = Integer.MAX_VALUE;
                parent[i][j] = new ParentNode(i,j);
            }
        }
        distance[0][0] = 0;

        //define pq
        PriorityQueue<DistanceNode> pq = new PriorityQueue<>(1, DistanceNodeCompare);
        pq.add(new DistanceNode(0, 0, 0));
        while(!pq.isEmpty()){
            DistanceNode node = pq.poll();
            for(int i=0;i<8;i++){
                int f_x = node.x + directionx[i];
                int f_y = node.y + directiony[i];
                try {
                    if(grid[f_x][f_y] == 0 && distance[node.x][node.y] + 1 < distance[f_x][f_y]){
                        distance[f_x][f_y] = distance[node.x][node.y] + 1;
                        pq.add(new DistanceNode(distance[f_x][f_y], f_x, f_y));
                        parent[f_x][f_y] = new ParentNode(node.x, node.y);
                    }
                }
                catch(Exception e) {
                    continue;
                }
            }
        }
        int currnodex = n-1;
        int currnodey = n-1;
        if(distance[currnodex][currnodey] == Integer.MAX_VALUE) return -1;

        int count = 1;
        while(currnodex != 0 || currnodey != 0){
            ParentNode p = parent[currnodex][currnodey];
            currnodex = p.x;
            currnodey = p.y;
            count++;
        }
        return count;
    }
}
