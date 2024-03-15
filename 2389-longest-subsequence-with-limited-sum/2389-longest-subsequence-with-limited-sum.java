class Solution {
    public int[] answerQueries(int[] numbers, int[] queries) {
        int queryLength = queries.length;
        int[] results = new int[queryLength];
        Arrays.sort(numbers);
        int runningSum = 0;
        int runningCount = 0;
        for(int i = 0; i < queryLength; i++){
            int breakFlag = 0;
            for(int j = 0; j < numbers.length; j++){
                if(runningSum + numbers[j] <= queries[i]){
                    runningSum += numbers[j];
                    runningCount++;
                }
                else{
                    results[i] = runningCount;
                    runningCount = 0;
                    runningSum = 0;
                    breakFlag = 1;
                    break;
                }
            }
            if(breakFlag == 0){
                results[i] = runningCount;
                runningCount = 0;
                runningSum = 0;
            }
        }
        return results;
    }
}
