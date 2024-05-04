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
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Integer> ans = new ArrayList<>();
        if (root==null) return ans;
        while (!q.isEmpty()) {
            int s=q.size();
            int n=0;
            for (int i=0;i<s;i++) {
                TreeNode cur = q.poll();
                if (cur!=null){
                    if (cur.left!=null) q.offer(cur.left);
                    if (cur.right!=null) q.offer(cur.right);
                    n=cur.val;
                }
            }
            ans.add(n);
        }
        return ans;
    }
}