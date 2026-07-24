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
        int c = 0;
        ListNode nHead = head;
        ListNode start = null;
        ListNode leftOver = null;
        ListNode ans = null;
        ListNode prevLast = null;
        while(nHead != null){
            c++;
            if(c == 1){
                start = nHead;
            }
            if(c == k){
                leftOver = nHead.next;
                nHead.next = null;
                ListNode last = reverse(start);
                if(ans == null){
                    ans = last;
                }
                if(prevLast != null){
                    prevLast.next = last;
                }
                start.next = leftOver;
                prevLast = start;
                c = 0;
                nHead = start;
            }
            nHead = nHead.next;
        }
        return ans;
        
    }

    public ListNode reverse(ListNode head){
        ListNode rev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = rev;
            rev = head;
            head = temp;
        }
        return rev;
    }
}
