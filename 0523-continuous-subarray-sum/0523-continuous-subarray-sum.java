class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            int mod = sum%k;
            if ((mod==0) && (i>=1)){
                return true;
            }
            if (hp.containsKey(mod)) {
                if (i-hp.get(mod) >= 2){
                    return true;
                }
            }else {
                hp.put(mod,i);
            }
        }
        return false;
    }
}