package Tree;

public class DiameterofBinaryTree {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
    Memory Usage: 41.7 MB, less than 97.62% of Java online submissions for Diameter of Binary Tree.

    class Solution {
    int max = 0;
    // The diameter is left height + right height
    // The height is Math.max(left height, right height) + 1
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}
    They may ask not to put max as a property of a class. Unlike c# or c++, java does not allow pass parameter
    by reference for primitive values. So we can create a wrapper.

     The diameter is left + right height
     The height is Math.max(left, right) + 1
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Self<Integer> max = new Self(0);
        height(root, max);
        return max.v;
    }
    private int height(TreeNode root, Self<Integer> max) {
        if (root == null) return 0;
        int left = height(root.left, max);
        int right = height(root.right, max);
        max.v = Math.max(left + right, max.v);
        return 1 + Math.max(left, right);
    }
    public class Self<E> {
        public E v;
        public Self(E e) {
            v = e;
        }
    }
}
