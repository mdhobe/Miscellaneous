/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        while(head.val == val && head != null){
            if(head.next == null){
                head = null;
                return head;
            } else{
                head = head.next;
            }
        }
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode ans = new ListNode(0);
        ans.next = head;
        
        while(head != null){
            if(head.val == val){
                head = head.next;
                prev.next = head;
            } else {
                head = head.next;
                prev = prev.next;
            }
        }
        
        return ans.next;
    }
}
