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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int length=1;
        ListNode a = head, b = head, c = head;
        while(c.next != null){
            length++;
            c = c.next;
        }
        if(k%length == 0) return head;
        int r = length-k%length;
        while(r-- > 1){
            b = b.next;
        }
        head = b.next;
        b.next = null;
        c.next = a;
        return head;
    }
}
