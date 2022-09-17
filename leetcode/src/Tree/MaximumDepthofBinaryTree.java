package Tree;

public class MaximumDepthofBinaryTree {
    /*
      Depth-First Search Approach
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 43.2 MB, less than 39.91% of Java online submissions for Maximum Depth of Binary Tree.
    */

    public int maxDepth(TreeNode root) {
        int s=1;
        if(root==null){
            return 0;
        }
        int right=maxDepth(root.right);
        int left=maxDepth(root.left);
        int d= Math.max(right, left); // or int d = (right>left)?right:left;  Same thing
        return s+d;
    }
}
