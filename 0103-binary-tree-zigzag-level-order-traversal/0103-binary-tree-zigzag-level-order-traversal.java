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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        boolean flag =true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0;i<s;i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);
            }
            if (flag==true){
                ans.add(temp);
                flag=false;
            }else {
                Collections.reverse(temp);
                ans.add(temp);
                flag=true;
            }
        }
        return ans;
    }
}