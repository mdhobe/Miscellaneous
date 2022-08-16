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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        ListNode node = head;
        int loc = -n, length = 0;
        
        while(end != null){
            end = end.next;
            length++;
            loc++;
            if(loc > 1) head = head.next;
        }
        
        System.out.println(length);
        
        if(length == n) node = head.next;
        else head.next = head.next.next;
        
        return node;
    }
}
