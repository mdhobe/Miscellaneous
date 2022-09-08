// Using 2 Queue
// class MyStack {
    
//     Queue<Integer> q1;
//     Queue<Integer> q2;

//     public MyStack() {
//         q1 = new LinkedList<Integer>();
//         q2 = new LinkedList<Integer>();
//     }
    
//     public void push(int x) {
//         q2.add(x);
//         while(!q1.isEmpty()) q2.add(q1.poll());
//         while(!q2.isEmpty()) q1.add(q2.poll());
//     }
    
//     public int pop() {
//         return q1.poll();
//     }
    
//     public int top() {
//        return q1.peek();
//     }
    
//     public boolean empty() {
//         if(q1.isEmpty()) return true;
//         return false;
//     }
// }

// Using 1 Queue
class MyStack {
    
    Queue<Integer> q1;

    public MyStack() {
        q1 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q1.add(x);
        int size = q1.size();
        while(size --> 1){
            q1.add(q1.poll());
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
       return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()) return true;
        return false;
    }
}
