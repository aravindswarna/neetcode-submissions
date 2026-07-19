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
        int rem = 0;
        ListNode ans = null;
        ListNode tracker = null;

        while(l1 != null || l2 != null) {

            int sum  = 0;
            if(l1 != null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum+=l2.val;
                l2 = l2.next;
            }
            sum+=rem;
            rem = sum/10;

            sum = sum%10;
            
            ListNode node = new ListNode(sum);
            if(ans == null){
                ans = node;
                tracker = node;
            } else {
                tracker.next = node;
                tracker = tracker.next;
            }

        }

        if(rem > 0){
              ListNode node = new ListNode(rem);  
              tracker.next = node;
        }
        return ans;
    }
}
