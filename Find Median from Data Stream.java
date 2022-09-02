class MedianFinder {
    int size = 0;
    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;
    int median = 0;

    public MedianFinder() {
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        larger = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        size++;
        if(size == 1){
            median = num;
            return;
        }
        
        if(num <= median){
            smaller.add(num);
        } else {
            larger.add(num);
        }
        
        if(size%2 == 1 && smaller.size() != larger.size()){
            if(smaller.size() > larger.size()){
                larger.add(median);
                median = smaller.poll();
            } else {
                smaller.add(median);
                median = larger.poll();
            }
        }
    }
    
    public double findMedian() {
        if(larger.size() == smaller.size()) return median;
        
        if(smaller.size() > larger.size()){
            return (median + smaller.peek())/2.0;
        } else {
            return (median + larger.peek())/2.0;
        }
    }
}
