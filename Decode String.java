class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
			if (s.charAt(i) == ']') {
				stack.pop();
				StringBuilder a = new StringBuilder();
				while (stack.peek() != '[') {
					a.insert(0, stack.pop());
				}
				stack.pop();
				StringBuilder n = new StringBuilder();
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					n.insert(0, stack.pop());
				}
				int num = Integer.parseInt(n.toString());
				for (int j = 0; j < num; j++) for (int k = 0; k < a.length(); k++) stack.push(a.charAt(k));
			}
		}

		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty()) ans.insert(0, stack.pop());

		return ans.toString();
    }
}
