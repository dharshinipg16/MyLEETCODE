class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] box: dislikes) {
            adj.get(box[0]).add(box[1]);
            adj.get(box[1]).add(box[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] colored = new int[n+1];
        Arrays.fill(colored,-1); //initially all uncolored
        q.offer(1);
        colored[1]=1;
        //boolean flag=true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int child: adj.get(cur)){
                if (colored[child]==-1){
                    colored[child] = (colored[cur]==1)?0:1;
                    q.offer(child);
                }
            }
        }
        for (int i=0;i<n;i++) {
            if (colored[i]==-1){
                q.offer(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int child: adj.get(cur)){
                        if (colored[child]==-1){
                            colored[child] = (colored[cur]==1)?0:1;
                            q.offer(child);
                        }
                    }
                }
            }
        }
        for (int i:colored) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int[] box: dislikes) {
            if (colored[box[0]]==colored[box[1]]){
                return false;
            }
        }
        return true;
        
    }
}