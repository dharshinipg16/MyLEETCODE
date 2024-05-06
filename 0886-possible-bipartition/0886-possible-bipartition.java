class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        //create the adjacent list
        for (int[] box: dislikes) {
            adj.get(box[0]).add(box[1]);
            adj.get(box[1]).add(box[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] colored = new int[n+1];
        Arrays.fill(colored,-1); //initially all uncolored
        
        //offer the first node and set the color to 1
        q.offer(1);
        colored[1]=1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            //get the child of the current node and assign opposite colors to them, add them in the queue
            for(int child: adj.get(cur)){
                if (colored[child]==-1){
                    colored[child] = (colored[cur]==1)?0:1;
                    q.offer(child);
                }else {
                    if (colored[child]==colored[cur]) return false;
                }
                
            }
        }
        //in case there are disjoint components in the graph, travers through the uncolored nodes and do the same process of q as above
        for (int i=0;i<n;i++) {
            if (colored[i]==-1){
                q.offer(i);
                while(!q.isEmpty()) {
                    int cur = q.poll();
                    for(int child: adj.get(cur)){
                        if (colored[child]==-1){
                            colored[child] = (colored[cur]==1)?0:1;
                            q.offer(child);
                        } else {
                            if (colored[child]==colored[cur]) return false;
                        }
                    }
                }
            }
        }
        // for (int i:colored) {
        //     System.out.print(i+" ");
        // }
        //traverse
        
        return true;
        
    }
}