/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tempNode = head;
        while(tempNode != null){
            Node node = new Node(tempNode.val);
            node.next = tempNode.next;
            tempNode.next = node;
            tempNode = node.next;
        }
        tempNode = head;

        Node newList = null;
        Node headNew = null;
        Node headOld = head;
        while(tempNode != null && tempNode.next != null){
            if(tempNode.random != null){
                tempNode.next.random = tempNode.random.next;
            }
            tempNode = tempNode.next.next;

        }
        tempNode = head;
        Node ans = null;
        Node newNode = null;
        while(tempNode != null && tempNode.next != null){
            Node temp = tempNode.next;
            tempNode.next = tempNode.next.next;
            tempNode = tempNode.next;
            if(ans == null){
                ans = temp;
                newNode = temp;
            } else {
                newNode.next = temp;
                newNode = newNode.next;
            }
        }


        return ans;
    }
}
