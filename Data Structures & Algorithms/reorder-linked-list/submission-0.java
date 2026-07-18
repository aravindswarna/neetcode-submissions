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
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode secHalf = mid.next;
        mid.next = null;
        ListNode sR = reverseList(secHalf);
        ListNode headTemp = head;
        while(headTemp != null && sR != null){
            ListNode temp1 = headTemp.next;
            ListNode temp2 = sR.next;
            sR.next = temp1;
            headTemp.next = sR;
            sR = temp2;
            headTemp = temp1;
        }

    }


    public ListNode reverseList(ListNode head) {
        if( head == null) return null;
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }

    public ListNode midNode(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        //[0]
        while(fp != null && fp.next != null) {
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }


}
