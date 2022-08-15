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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if (list1 == null) return list2;
//         if (list2 == null) return list1;
        
//         ListNode ans = new ListNode();
//         ListNode curr = ans;
        
//         while(list1 != null && list2 != null){
//             if(list1.val < list2.val){
//                 curr.next = list1;
//                 list1 = list1.next;
//             }else{
//                 curr.next = list2;
//                 list2 = list2.next;
//             }
            
//             curr = curr.next;
            
//             if(list1 == null){
//                 curr.next = list2;
//             }else if(list2 == null){
//                 curr.next = list1;
//             }
//         }
        
//         return ans.next;
//     }
// }
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        ListNode ans = list1;
        while(list1 != null && list2 != null){
            ListNode temp = null;
            while(list1 != null && list1.val <= list2.val){
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;
            
            ListNode node = list1;
            list1 = list2;
            list2 = node;
        }
        return ans;
    }
}
