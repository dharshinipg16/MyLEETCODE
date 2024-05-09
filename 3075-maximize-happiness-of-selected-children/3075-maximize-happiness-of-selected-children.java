class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0, count = 0;
        for(int i = happiness.length - 1; i >= 0; i--) {
            sum += Math.max(0, happiness[i] - count);
            count += 1;
            if(count >= k) {
                break;
            }
        }
        return sum;
    }
}