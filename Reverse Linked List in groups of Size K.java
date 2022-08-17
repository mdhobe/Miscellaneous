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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode c = head;
        int length = 0;
        while(c != null){
            length++;
            c = c.next;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prev = dummyHead;
        ListNode cur;
        ListNode nex;
        
        while(length >= k){
            cur = prev.next;
            nex = cur.next;
            for(int i=1;i<k;i++){
                cur.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = cur.next;
            }
            prev = cur;
            length -= k;
        }
        
        return dummyHead.next;
    }
}
