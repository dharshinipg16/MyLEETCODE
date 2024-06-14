class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int l = nums.length;
        int a = 0 ;
        int count = 0 ;
        int i = 0;
        while (i<l){
            a += nums[i];
            if (a==0) count++; 
            i++;
        }
        return count;
    }
}