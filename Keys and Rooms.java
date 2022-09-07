class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] set = new int[rooms.size()];
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < rooms.get(0).size(); i++) {
			queue.add(rooms.get(0).get(i));
		}

		while (!queue.isEmpty()) {
			int room = queue.poll();
			set[room] = 1;

			for (int j = 0; j < rooms.get(room).size(); j++) {
				if (set[rooms.get(room).get(j)] == 0) {
					queue.add(rooms.get(room).get(j));
				}
			}
		}

		for (int i = 1; i < rooms.size(); i++){
			if(set[i] == 0) return false;
		}

		return true;
    }
}
