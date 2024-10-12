# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: Optional[TreeNode]) -> int:
        if not root :
            return 0
        rh,lh = 0,0
        curr = root
        while (curr):
            lh+=1
            curr = curr.left
        curr=root
        while (curr):
            rh+=1
            curr = curr.right
        if (rh==lh) :
            return (pow (2,lh)-1)
        return (1 + self.countNodes(root.left) + self.countNodes(root.right))