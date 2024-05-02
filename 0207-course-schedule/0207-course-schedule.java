class Solution {
    public boolean canFinish(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree =new int[n];
        
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] box : arr) {
            adj.get(box[0]).add(box[1]);
        }
        
        for (int i=0;i<n;i++) {
            for (int j: adj.get(i)) {
                indegree[j]++; //no of prerequisite for course j is indegree[j]
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> completed = new ArrayList<>();
        
        for (int i=0;i<n;i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            completed.add(cur);
            for (int child : adj.get(cur)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        if (completed.size()==n) return true;
        return false;
    }
}