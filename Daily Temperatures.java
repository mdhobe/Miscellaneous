class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int len = temperatures.length;
        int[] ans = new int[len];
        
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            Pair<Integer, Integer> pair = null;
            
            while (!stack.empty() && temperatures[i] > stack.peek().getKey()) {
                pair = stack.pop();
                ans[pair.getValue()] = i - pair.getValue();
            }
            
            stack.push(new Pair<>(temperatures[i], i));
        }
        return ans;
    }
}
