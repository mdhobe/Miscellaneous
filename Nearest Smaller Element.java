public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < A.size(); i++) {
			if (stack.isEmpty()) {
				ans.add(-1);
			} else {
				if (stack.peek() < A.get(i)) {
					ans.add(stack.peek());
				} else {
					while (!stack.isEmpty() && stack.peek() >= A.get(i)) stack.pop();
					if (stack.isEmpty()) {
						ans.add(-1);
					} else {
						ans.add(stack.peek());
					}
				}
			}
			stack.add(A.get(i));
		}
        return ans;
    }
}
