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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //both null
        if (p == null && q == null) {
            return true;
        }
        
        //only one null (structure mismatch)
        if (p == null || q == null) {
            return false;
        }
        
        // value mismatch
        if (p.val != q.val) {
            return false;
        }
        
        boolean leftComparison = isSameTree(p.left, q.left);
        boolean rightComparison = isSameTree(p.right, q.right);
        
        if (!leftComparison || !rightComparison) {
            return false;
        }
        
        return true;
    }
}
