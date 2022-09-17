package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    /*
    Using String Builder
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
    Memory Usage: 41.4 MB, less than 99.18% of Java online submissions for Binary Tree Paths.
     */
    List<String> result = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new StringBuilder());
        return result;
    }
    void helper(TreeNode node, StringBuilder slate){
        if(node==null) return;
        int length = slate.length();
        slate.append(node.val);
        if(node.left == null && node.right == null)
            result.add(slate.toString());
        else{
            slate.append("->");
            helper(node.left, slate);
            helper(node.right, slate);
        }
        slate.setLength(length);
    }
}
