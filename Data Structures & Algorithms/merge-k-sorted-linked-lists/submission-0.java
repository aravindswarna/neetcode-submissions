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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = 0;
        ListNode head = null;
        ListNode next = null;
        while(size < lists.length){
            int minIdx = lists.length+1;
            int minValue = Integer.MAX_VALUE;
            for(int i = 0; i<lists.length; i++){
                if(lists[i] != null && lists[i].val <= minValue){
                    minValue = lists[i].val;
                    minIdx = i;
                }
            }

            ListNode node = lists[minIdx];
            if(node.next == null){
                size++;
            }
            lists[minIdx] = node.next;
            node.next = null;
            if(head == null){
                
                head = node;
                next = head;
            } else {
                next.next = node;
                next = node;
            }

        }
        return head;
    }
}
