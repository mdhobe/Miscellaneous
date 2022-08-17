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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> myarray = new ArrayList<>();
        while(head != null){
            myarray.add(head.val);
            head = head.next;
        }
        for(int i=0;i<myarray.size()/2;i++){
            if(myarray.get(i) != myarray.get(myarray.size()-1-i)) return false;
        }
        return true;
    }
}
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null) fast = fast.next;
            slow = slow.next;
        }
        ListNode rev = reverseList(slow);
        while(head != null && rev != null){
            if(head.val != rev.val) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        while(head != null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
