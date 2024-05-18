class Solution {
    int numMov;
    public int distributeCoins(TreeNode root) {
        numMov = 0;
        givenCoin(root);
        return numMov;
    }

    public int givenCoin(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = givenCoin(node.left);
        int right = givenCoin(node.right);
        numMov += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}