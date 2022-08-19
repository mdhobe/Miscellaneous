/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = head;
        HashMap<Node, Node> copy = new HashMap<>();
        while(dummy != null){
            Node item = new Node(dummy.val);
            copy.put(dummy, item);
            dummy = dummy.next;
        }
        System.out.println(copy);
        
        Node start = head;
        Node ans = new Node(0);
        Node a = ans;
        
        while(head != null){
            ans.next = copy.get(head);
            ans.next.next = copy.get(head.next);
            ans.next.random = copy.get(head.random);
            head = head.next;
            ans = ans.next;
        }
        
        return a.next;
    }
}
