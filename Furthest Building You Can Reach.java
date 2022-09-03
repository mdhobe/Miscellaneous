class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int heightClimbedUsingLadders = 0, totalHeightClimbed = 0, n = heights.length;
        for (int building = 0; building < n - 1; building++) {
            int diff = heights[building + 1] - heights[building];
            if (diff <= 0) continue;
            totalHeightClimbed += diff;
            heightClimbedUsingLadders += diff;
            pq.offer(diff);
            if (pq.size() > ladders) heightClimbedUsingLadders -= pq.poll();
            if (totalHeightClimbed - heightClimbedUsingLadders > bricks) return building;
        }
        return n - 1;
    }
}
