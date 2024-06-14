class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int i = nums.size() - 1;
        
        for(; i > -1 && set.size() != k; i--) {
            if(nums.get(i) <= k) set.add(nums.get(i));
        }
        
        return nums.size() - i - 1;
    }
}