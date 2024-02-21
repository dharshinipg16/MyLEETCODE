class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || right == 0) return 0;
        
        int ans = left; // Initialize ans with left
        
        // Find common MSB bits of left and right
        while (left < right) {
            right = right & (right - 1); // Turn off rightmost set bit of right
            if (right == 0) return 0; // If right becomes 0, the loop breaks
        }
        
        // The remaining left is the bitwise AND of the range
        return right;
    }
}
