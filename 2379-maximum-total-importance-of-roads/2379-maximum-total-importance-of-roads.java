import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        long ans = 0;
        for (int[] t : roads) {
            hp.put(t[0], hp.getOrDefault(t[0], 0) + 1);
            hp.put(t[1], hp.getOrDefault(t[1], 0) + 1);
        }
        long[] arr = new long[n]; // Changed to long array
        for (int i = 0; i < n; i++) {
            arr[i] = hp.getOrDefault(i, 0);
        }
        Arrays.sort(arr);
        for (int i = 1; i <= n; i++) {
            ans += arr[i - 1] * (long) i; // Explicit cast to long
        }
        return ans;
    }
}
