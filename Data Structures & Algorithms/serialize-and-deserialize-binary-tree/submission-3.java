/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        TreeNode dummy = new TreeNode();
        TreeNode dummy2 = new TreeNode();

        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.addLast(root);
        Q.addLast(dummy);
        int pvOneNonDummy = 0;
        int crOneNonDummy = 0;

        while(!Q.isEmpty()){

            TreeNode node = Q.removeFirst();
            //System.out.println(node.val);
            if(node == dummy){
                if(!Q.isEmpty()){
                    Q.addLast(dummy);
                }
                pvOneNonDummy = crOneNonDummy;
                crOneNonDummy = 0;
                
            } else if(node == dummy2) {
                sb.append("#");
            } else {
                sb.append(node.val);
                sb.append("#");
                if(node.left != null){
                    Q.addLast(node.left);
                    crOneNonDummy++;
                } else {
                    Q.addLast(dummy2);
                }

                if(node.right != null){
                    Q.addLast(node.right);
                    crOneNonDummy++;
                } else {
                    Q.addLast(dummy2);
                }
            }

        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);

        String[] arr = data.split("#");
        TreeNode[] tArr = new TreeNode[arr.length];
        int i = 0;
        for(String str: arr){
            if(str.length() > 0){
                tArr[i] = new TreeNode(Integer.parseInt(str));
            }
            i++;
        }
        construct(tArr);
        return tArr[0];
        
        
    }

    public void construct(TreeNode[] arr){
        if(arr.length == 0 || arr[0] == null) return;
        int x = 0;
        Deque<TreeNode> Q = new ArrayDeque<>();
        int i = 0;
        Q.offer(arr[i]);
        i++;
        while(!Q.isEmpty()){
            TreeNode node = Q.poll();
            node.left = i<arr.length ? arr[i]: null;
            i++;
            node.right = i<arr.length ? arr[i]: null;
            i++;
            if(node.left != null){
                Q.offer(node.left);
            }
            if(node.right != null){
                Q.offer(node.right);
            }
        }


    }
}
