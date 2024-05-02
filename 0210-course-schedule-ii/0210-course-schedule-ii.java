class Solution {
     public int[] findOrder(int n, int[][] arr) {
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
            completed.add(0,cur);
            for (int child : adj.get(cur)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        int[] ans=new int[completed.size()];
        if (completed.size()==n){
            for(int i=0;i<completed.size();i++) {
                ans[i]=completed.get(i);
            }
            return ans;
        }
        return new int[]{};
    }
}