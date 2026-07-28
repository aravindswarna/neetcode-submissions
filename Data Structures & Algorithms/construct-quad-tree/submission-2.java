/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {

        return construct(grid, 0, grid.length-1, 0, grid.length-1);
        
    }

    public Node construct(int[][] grid, int l1, int l2, int r1, int r2) {

        if(l1 == l2){
            return new Node(grid[l1][r1] == 1, true); 
        }

        int lmid = (l1+l2)/2;
        int rmid = (r1+r2)/2;
        Node node = new Node(true, false);
        node.topLeft     = construct(grid, l1, lmid, r1, rmid);
        node.topRight    = construct(grid, l1, lmid, rmid + 1, r2);
        node.bottomLeft  = construct(grid, lmid + 1, l2, r1, rmid);
        node.bottomRight = construct(grid, lmid + 1, l2, rmid + 1, r2);

        if(node.topLeft.isLeaf && node.topRight.isLeaf &&
            node.bottomLeft.isLeaf && node.bottomRight.isLeaf){
                if(node.topLeft.val == node.topRight.val && 
                 node.topRight.val == node.bottomLeft.val &&  node.bottomLeft.val == node.bottomRight.val){
                    node.val = node.topLeft.val;
                    node.isLeaf = true;
                    node.topLeft = null;
                    node.topRight = null;
                    node.bottomLeft = null;
                    node.bottomRight = null;
                    //System.out.println(node.val+"--");
                 }
        }
        return node;

    }
}