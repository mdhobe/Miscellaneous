/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//HashSet
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> seta = new HashSet<>();
        
        while(headA != null){
            seta.add(headA);
            headA = headA.next;
        }
        
        while(headB != null){
            if(seta.contains(headB))return headB;
            headB = headB.next;
        }
        
        return null;
    }
}

//Optimum 1 Difference Length
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA, dummyB = headB;
        int lenA=0, lenB=0;
        
        //get lengths of A & B
        while(dummyA != null){
            lenA++;
            dummyA = dummyA.next;
        }
        while(dummyB != null){
            lenB++;
            dummyB = dummyB.next;
        }
        
        //increment long one
        if(lenA > lenB){
            for(int i=0;i<lenA-lenB;i++){
                headA = headA.next;
            }
        } else if(lenA < lenB){
            for(int i=0;i<lenB-lenA;i++){
                headB = headB.next;
            }
        }
        
        //compare nodes
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
//Optimum 1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA, dummyB = headB;
        
        while(dummyA != null && dummyB != null){
            if(dummyA == dummyB) return dummyA; 
            
            dummyA = dummyA.next;
            dummyB = dummyB.next;
            if(dummyA == null && dummyB == null) return null;
            
            if(dummyA == null) dummyA = headB;
            if(dummyB == null) dummyB = headA;
        }
        
        return null;
    }
}
