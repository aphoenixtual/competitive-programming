package Tree;

public class SymmetricTree {

    /*
     Recursive Solution
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     Memory Usage: 37.4 MB, less than 74.15% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetric(TreeNode root) {
        return root==null || traverse(root.left,root.right);
    }
    private boolean traverse(TreeNode one,TreeNode two){
        if(one==null && two==null)return true;
        if(one==null || two==null)return false;
        if(one.val!=two.val)return false;
        boolean resl=traverse(one.left,two.right);
        if(!resl)return false;
        boolean resr=traverse(one.right,two.left);
        if(!resr)return false;
        return true;
    }
}
