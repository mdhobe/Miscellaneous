class StockSpanner {
    Stack<Integer> stack;
    HashMap<Integer, Integer> hash;
    int index = 0;

    public StockSpanner() {
        hash = new HashMap<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        index++;
        hash.put(index, price);
        
        if(stack.isEmpty()){
            stack.push(index);
            return 1;
        } else {
            while(!stack.isEmpty() && hash.get(stack.peek()) <= price) stack.pop();
            
            if(stack.isEmpty()){
                stack.push(index);
                return index;
            } else {
                int last_pos = stack.peek();
                stack.push(index);
                return index - last_pos;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
