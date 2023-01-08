class NodeSteps{
    int node, step;
    NodeSteps(int n, int s){
        node = n;
        step = s;
    }
}
class Solution {
    public Comparator<NodeSteps> NodeStepsComparator = new Comparator<NodeSteps>(){
          @Override
          public int compare(NodeSteps a, NodeSteps b){
              return a.step - b.step;
          }
      };
    int minimumMultiplications(int[] arr, int start, int end) {
        // Your code here
        PriorityQueue<NodeSteps> pq = new PriorityQueue<>(1, NodeStepsComparator);
        pq.add(new NodeSteps(start, 0));
        int[] steps = new int[100000];
        for(int i=0;i<100000;i++) steps[i] = Integer.MAX_VALUE;
        steps[start] = 0;
        while(!pq.isEmpty()){
            NodeSteps ns = pq.poll();
            for(int num : arr){
                int mul = num * ns.node;
                if(mul > 9999) mul %= 100000;
                if(mul == end) return ns.step+1;
                if(steps[mul] > ns.step+1){
                    steps[mul] = ns.step+1;
                    pq.add(new NodeSteps(mul, ns.step+1));
                }
            }
        }
        return -1;
    }
}
