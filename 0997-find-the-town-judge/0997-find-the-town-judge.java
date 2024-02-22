class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trusted = new int[n + 1];
        int[] untrusted = new int[n + 1];
       
        for (int[] t : trust){
            trusted[t[1]]++;
            untrusted[t[0]]++;
        }

        for (int i = 1; i < n + 1; i++){
            if (trusted[i] == n - 1 && untrusted[i] == 0)
                return i;           
        }

        return -1;        
    }
}