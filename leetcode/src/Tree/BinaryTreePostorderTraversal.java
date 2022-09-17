package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    /*
    Recursive Solution
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
    Memory Usage: 42.2 MB, less than 59.08% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return postOrderTraversal(root,list);
    }

    private List<Integer> postOrderTraversal(TreeNode root,List<Integer> list){
        if(root!=null){
            postOrderTraversal(root.left,list);
            postOrderTraversal(root.right,list);
            list.add(root.val);
        }
        return list;
    }
}
