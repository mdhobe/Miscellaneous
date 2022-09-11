// Using Time - O(n), Space - O(2n)
// class MinStack {
    
//     Stack<Pair<Integer, Integer>> stack; 

//     public MinStack() {
//         stack = new Stack<>(); 
//     }
    
//     public void push(int val) {
//         if(stack.isEmpty()){
//             Pair<Integer, Integer> pair = new Pair<Integer, Integer>(val,val);
//             stack.push(pair);
//         } else {
//             Pair<Integer, Integer> p = stack.peek();
//             Pair<Integer, Integer> pair = new Pair<Integer, Integer>(val, Math.min(val, p.getValue()));
//             stack.push(pair);
//         }
//     }
    
//     public void pop() {
//         stack.pop();
//     }
    
//     public int top() {
//         return stack.peek().getKey();
//     }
    
//     public int getMin() {
//         return stack.peek().getValue();
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Time - O(1), Space - O(n)

class MinStack {
    Stack<Long> stack = new Stack<>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(stack.isEmpty()){
            mini = val;
            stack.push(val);
        } else {
            if(val < mini){
                stack.push(2*val-mini);
                mini = val;
            } else {
                stack.push(val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        
        Long val = stack.pop();
        if(val < mini){
            mini = 2*mini-val;
        }
    }
    
    public int top() {
        Long val = stack.peek();
        if(val < mini){
            return mini.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
