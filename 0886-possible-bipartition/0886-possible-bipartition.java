class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] colored = new int[n+1];
        Arrays.fill(colored,-1);
        
        for (int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] box:dislikes) {
            adj.get(box[0]).add(box[1]);
            adj.get(box[1]).add(box[0]);
        }
        for (int i=0;i<=n;i++) {
            if (colored[i]==-1) {
                if (!bfs(adj,colored,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] colored, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        colored[start]=1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int curcolor = colored[cur];
            for (int child: adj.get(cur)) {
                if (colored[child]==-1){
                    colored[child]=1-curcolor;
                    q.offer(child);
                }
                else {
                    if (colored[child] == curcolor) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}