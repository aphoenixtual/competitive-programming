package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /*
     Recursive Solution
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
