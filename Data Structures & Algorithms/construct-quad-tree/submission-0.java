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
        int start = -1;
        boolean ans = true;
        for(int i = l1; i<=l2; i++){
            for(int j = r1; j<=r2; j++){
                if(start == -1){
                    start = grid[i][j];
                }
                ans = ans && (start == grid[i][j]);
                if(!ans) break;
            }
            if(!ans) break;
        }
        if(ans){
            Node node = new Node(start == 1, true);
            return node;
        } else {
            int lmid = (l1+l2)/2;
            int rmid = (r1+r2)/2;
            Node node = new Node(true, false);
           // Top-Left: Top rows (l1..lmid), Left cols (r1..rmid)
node.topLeft     = construct(grid, l1, lmid, r1, rmid);

// Top-Right: Top rows (l1..lmid), Right cols (rmid+1..r2)
node.topRight    = construct(grid, l1, lmid, rmid + 1, r2);

// Bottom-Left: Bottom rows (lmid+1..l2), Left cols (r1..rmid)
node.bottomLeft  = construct(grid, lmid + 1, l2, r1, rmid);

// Bottom-Right: Bottom rows (lmid+1..l2), Right cols (rmid+1..r2)
node.bottomRight = construct(grid, lmid + 1, l2, rmid + 1, r2);
            return node;
        }

    }
}