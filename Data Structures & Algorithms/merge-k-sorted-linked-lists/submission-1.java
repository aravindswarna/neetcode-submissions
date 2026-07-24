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
        Queue<ListNode> Q = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        for(ListNode node: lists){
            Q.add(node);
        }
        while(!Q.isEmpty()){
         ListNode node = Q.poll();
         if(head == null){
                head = node;
                next = head;
            } else {
                next.next = node;
                next = node;
            }
            if(node.next != null){
                Q.add(node.next);
            }

        }
        return head;
    }
}
