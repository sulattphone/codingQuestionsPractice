/**
  * Description: Find the sum of left leaves. Root is not a left leaf.
  * Comment: Forgot to check if root is null.
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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return oneBranch(root, false);
    }
    
    public int oneBranch(TreeNode node, boolean isLeft) {
        if ((node.left == null) && (node.right == null)) {
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }
        if (node.left == null) {
            return oneBranch(node.right, false);
        }
        if (node.right == null) {
            return oneBranch(node.left, true);
        }
        return oneBranch(node.left, true) + oneBranch(node.right, false);
    }
}
