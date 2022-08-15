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
    public ListNode middleNode(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        
        do{
            if(one.next == null) return one;
            if(two.next == null) return one;
            one = one.next;
            two = two.next;
            if(two.next != null) two = two.next;
        } while(two != null);
        
        return one;
    }
}
