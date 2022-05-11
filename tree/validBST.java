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
    public boolean isValidBST(TreeNode root) {
        List<List<Integer>> parentsVals = new ArrayList<>();
        return isValidBSTWithParents(root, parentsVals);
    }
    
    private boolean isValidBSTWithParents(TreeNode root, List<List<Integer>> parentsVals) {
        if (root == null) {
            return true;
        }
        
        List<List<Integer>> leftParents = copyParentsVals(parentsVals);
        List<Integer> leftRoot = new ArrayList<>();
        leftRoot.add(root.val);
        leftRoot.add(0);
        leftParents.add(leftRoot);
        
        if (root.left != null && !isInCorrectPlace(root.left.val, leftParents)) {
            return false;
        }
        
        List<List<Integer>> rightParents = copyParentsVals(parentsVals);
        List<Integer> rightRoot = new ArrayList<>();
        rightRoot.add(root.val);
        rightRoot.add(1);
        rightParents.add(rightRoot);
        
        if (root.right != null && !isInCorrectPlace(root.right.val, rightParents)) {
            return false;
        }
        
        boolean isLeftValid = isValidBSTWithParents(root.left, leftParents);
        boolean isRightValid = isValidBSTWithParents(root.right, rightParents);
        
        return isLeftValid && isRightValid;
    }
    
    private boolean isInCorrectPlace(int currentVal, List<List<Integer>> allAncestors) {
        for (List<Integer> ancestorPair : allAncestors) {
            if (ancestorPair.get(1) == 0 && currentVal >= ancestorPair.get(0)) {
                return false;
            }
            if (ancestorPair.get(1) == 1 && currentVal <= ancestorPair.get(0)) {
                return false;
            }
        }
        return true;
    }
    
    
    
    private List<List<Integer>> copyParentsVals(List<List<Integer>> original) {
        List<List<Integer>> copy = new ArrayList<>();
        
        for (List<Integer> pair : original) {
            List<Integer> copyPair = new ArrayList<>();
            copyPair.add(pair.get(0));
            copyPair.add(pair.get(1));
            copy.add(copyPair);
        }
        return copy;
        
    }
}

// More efficient solution
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,Integer min,Integer max){
        if(root == null)return true;
        if(min != null && min >= root.val)return false;
        if(max != null && max <= root.val)return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}
