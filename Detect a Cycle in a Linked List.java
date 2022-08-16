/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Nave
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> node = new HashSet<>();
        
        while(head != null){
            if(node.contains(head)) return true;
            else{
                node.add(head);
                head = head.next;
            }
        }
        
        return false;
    }
}

//Pointer
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        
        while(fast != null){
            fast = fast.next;
            if(fast == null) return false;
            else fast = fast.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        
        return false;
    }
}
