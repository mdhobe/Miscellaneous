class LRUCache {
    int capacity = 0;
    HashMap<Integer, Node> hash = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node node = hash.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else return -1;
    }
    
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            remove(hash.get(key));
        }
        if(hash.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    public void remove(Node node){
        hash.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(Node node){
        hash.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    class Node {
        Node prev, next;
        int key, val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
