class LFUCache {
    final int capacity;
    int curSize, minFrequency;
    HashMap<Integer, DLLNode> cache;
    HashMap<Integer, DoubleLinkedList> frequencyMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 1;
        
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if(curNode == null) return -1;
        updateNode(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return ;
        if(cache.containsKey(key)){
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            curSize++;
            if(curSize > capacity){
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key,value);
            
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);
        }
    }
    
    public void updateNode(DLLNode curNode){
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        
        if(curFreq == minFrequency && curList.listSize == 0){
            minFrequency++;
        }
        
        curNode.frequency++;
        
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }
    
    class DLLNode {
        int key, val, frequency;
        DLLNode prev, next;
        
        public DLLNode (int key, int value){
            this.key = key;
            this.val = value;
            this.frequency = 1;
        }
    }
    
    class DoubleLinkedList {
        int listSize;
        DLLNode head, tail;
        
        public DoubleLinkedList (){
            this.listSize = 0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(DLLNode curNode){
            DLLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }
        
        public void removeNode(DLLNode curNode){
            DLLNode prevNode = curNode.prev;
            DLLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
