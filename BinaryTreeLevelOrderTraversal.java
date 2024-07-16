// Time Complexity : O(n)
// Space Complexity : O(n) - n is width of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

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

// Using BFS
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i =0; i< size; i++){
                TreeNode currentElement = q.poll();
                levelList.add(currentElement.val);
                if(currentElement.left != null){
                    q.add(currentElement.left);
                }
                if(currentElement.right != null){
                    q.add(currentElement.right);
                }
            }
            result.add(levelList);
        }

        return result;

    }
}