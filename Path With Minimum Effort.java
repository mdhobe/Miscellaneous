class DistanceNode {
    int distance, x, y;
    DistanceNode(int distance, int x, int y){
        this.distance = distance;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public Comparator<DistanceNode> DistNodeComparator = new Comparator<DistanceNode>(){
        @Override
        public int compare(DistanceNode a, DistanceNode b){
            return a.distance - b.distance;
        }
    };
    public int minimumEffortPath(int[][] heights) {
        int[] directx = {0, 1, 0, -1};
        int[] directy = {-1, 0, 1, 0};
        int rows = heights.length, columns = heights[0].length;
        if(rows == 1 && columns == 1) return 0;
        PriorityQueue<DistanceNode> pq = new PriorityQueue<>(1, DistNodeComparator);
        pq.add(new DistanceNode(0,0,0));
        int[][] distance = new int[rows][columns];
        for(int i=0;i<rows;i++) for(int j=0;j<columns;j++) distance[i][j] = Integer.MAX_VALUE;
        distance[0][0] = 0;
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            DistanceNode distanceNode = pq.poll();
            for(int i=0;i<4;i++){
                try{
                    int f_x = distanceNode.x + directx[i];
                    int f_y = distanceNode.y + directy[i];
                    int d = Math.max(distanceNode.distance, Math.abs(heights[f_x][f_y] - heights[distanceNode.x][distanceNode.y]));
                    if(f_x == rows-1 && f_y == columns-1) ans = Math.min(ans,d);
                    if(distance[f_x][f_y] > d){
                        distance[f_x][f_y] = d;
                        pq.add(new DistanceNode(d, f_x, f_y));
                    }
                } catch (Exception e){
                    continue;
                }
            }
        }
        return ans;
    }
}
