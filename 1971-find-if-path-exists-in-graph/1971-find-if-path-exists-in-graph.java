class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source ==  destination) 
        {
            return true;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Initializing empty arrays for each vertex
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<Integer>());
        }
        //traversing the edges, adding the possible dest in the respective vertices
        for (int i=0; i<edges.length ;i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //a boolean array to see if all the vertices can be visited, DFS so use stack to check the possibilities of exploratio from the current node
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack();
        visited[source]=true;
        stack.push(source);
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            for (int neighbour : adj.get(currentNode)) {
                if (!visited[neighbour]) {
                    visited[neighbour]=true;
                    stack.push(neighbour);
                }
            }
        }
        return visited[destination];
    }
}