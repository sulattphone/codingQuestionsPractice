/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        TreeNode node = root;
        map.put(node, null);
        
        while(node != null)
        {
            if(node.left != null && !map.containsKey(node.left))
            {
                map.put(node.left, node);
                node = node.left;
                continue;
            }
            else if (!map.containsKey(node.right))
            {
                result.add(node.val);
            }
            
            if(node.right != null && !map.containsKey(node.right))
            {
                map.put(node.right, node);
                node = node.right;
                continue;
            }
            else
            {
                node = map.get(node);
            }
            
        }
        
        return result;
        
    }
}
