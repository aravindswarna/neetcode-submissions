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
        ListNode dummy = new ListNode(0, head);
        ListNode fp = head;
        ListNode sp = dummy;
        while(n > 0){
            fp = fp.next;
            n--;
        }
        while(fp != null){
            sp = sp.next;
            fp = fp.next;
        }
        if(sp != null && sp.next != null){
            sp.next = sp.next.next;
        }
        return dummy.next;
    }
}
