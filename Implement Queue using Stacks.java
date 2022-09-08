// Using 2 Stacks
// class MyQueue {
//     Stack<Integer> s1;
//     Stack<Integer> s2;

//     public MyQueue() {
//         s1 = new Stack<Integer>();
//         s2 = new Stack<Integer>();
//     }
    
//     public void push(int x) {
//         while(!s1.isEmpty()) s2.push(s1.pop());
//         s1.push(x);
//         while(!s2.isEmpty()) s1.push(s2.pop());
//     }
    
//     public int pop() {
//         return s1.pop();
//     }
    
//     public int peek() {
//         return s1.peek();
//     }
    
//     public boolean empty() {
//         return s1.isEmpty();
//     }
// }

// Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.add(x);
    }
    
    public int pop() {
        if(output.isEmpty()){
            while(!input.isEmpty()) output.push(input.pop());
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()) output.push(input.pop());
        }
        return output.peek();
    }
    
    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()) return true;
        return false;
    }
}
