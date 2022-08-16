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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int offset = 0;
        
        ListNode ans = new ListNode();
        
        int val = l1.val + l2.val;
        if(val < 10){
            ListNode node = new ListNode(val);
            ans = node;
            offset=0;
        } else {
            ListNode node = new ListNode(val-10+offset);
            ans = node;
            offset=1;
        }
        ListNode pointer = ans;
        
        l1 = l1.next;
        l2 = l2.next;
        
        while(l1 != null && l2 != null){
            val = l1.val + l2.val + offset;
            if(val < 10){
                ListNode node = new ListNode(val);
                ans.next = node;
                offset=0;
            } else {
                ListNode node = new ListNode(val-10);
                ans.next = node;
                offset=1;
            }
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null){
            val = l1.val + offset;
             if(val < 10){
                ListNode node = new ListNode(val);
                ans.next = node;
                offset=0;
            } else {
                ListNode node = new ListNode(val-10);
                ans.next = node;
                offset=1;
            }
            l1 = l1.next;
            ans = ans.next;
        }
        
        while(l2!=null){
             val = l2.val + offset;
             if(val < 10){
                ListNode node = new ListNode(val);
                ans.next = node;
                offset=0;
            } else {
                ListNode node = new ListNode(val-10);
                ans.next = node;
                offset=1;
            }
            l2 = l2.next;
            ans = ans.next;
        }
        if(offset == 1){
            ListNode node = new ListNode(1);
            ans.next = node;
            ans = ans.next;
        }
        return pointer;
    }
}
