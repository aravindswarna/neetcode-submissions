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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = head;
        ListNode s = null;
        ListNode e = null;
        ListNode prev = null;
        ListNode first = null;
        ListNode last = null;
        int count = 1;
        while(temp != null){
            if(count == left){
                s = temp;
                first = prev;
            }
            if(count == right){
                e = temp;
                last = e.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            count++;
        }
        if(first != null) first.next = null;
        if(e != null) e.next = null;
        temp = s;
        ListNode rev = null;
        while(temp != last && temp != null) {
            ListNode temp2 = temp.next;
            temp.next = rev;
            rev = temp;
            temp = temp2;
        }
        
        if( first != null ){
            first.next = rev;
            first = head;
        } else {
            first = rev;
        }
        s.next = last;
        return first;
    }
}