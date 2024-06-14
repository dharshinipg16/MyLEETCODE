class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int sum = 0;
        for(int i = 0;i < nums1.length;i++){
            sum += nums1[i];
        }
        for(int i = 0;i < nums2.length;i++){
            sum -= nums2[i];
        }
        return -1 * sum/nums1.length;
    }
}