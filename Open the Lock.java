class Solution {
    public int openLock(String[] deadends, String target) {
		HashSet<String> visited = new HashSet<>();
		for (String dead : deadends) visited.add(dead);
        
        if(visited.contains("0000")) return -1;

		Queue<Points> queue = new LinkedList<>();
		queue.add(new Points("0000", 0));

		while (!queue.isEmpty()) {
			Points point = queue.poll();
			visited.add(point.lock);

			if (point.lock.equals(target)) return point.turns;

			for (String pattern : getNebour(point.lock)) {
				if (!visited.contains(pattern)) {
					visited.add(pattern);
					queue.add(new Points(pattern, point.turns + 1));
				}
			}
		}

		return -1;
	}

	public ArrayList<String> getNebour(String l) {
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			StringBuilder locka = new StringBuilder(l);
			int na = Character.getNumericValue(locka.charAt(i));
			int val = (na + 1) % 10;
			char a = (char)(val + '0');
			locka.setCharAt(i, a);
			ans.add(locka.toString());

			StringBuilder locks = new StringBuilder(l);
			int ns = Character.getNumericValue(locks.charAt(i));
			int vals = (ns - 1 + 10) % 10;
			char s = (char)(vals + '0');
			locks.setCharAt(i, s);
			ans.add(locks.toString());
		}

		return ans;
	}

	public class Points {
		public int turns = 0;
		public String lock;
		Points(String lock, int turns) {
			this.turns = turns;
			this.lock = lock;
		}
	}

}
