import java.util.*;

class Solution {
    HashMap<Integer, Integer> graph;
    HashMap<Integer, Integer> graphSize;
    int ans = 0;
    
    int calculateGraphSize(int node){
        Integer childNode = graph.get(node);
        
        if(childNode == null){
            graphSize.put(node, 1);
        }
        else if(graphSize.get(childNode)>0){
            graphSize.put(node, graphSize.get(childNode)+1);
        }
        else{
            int graphSizeFromChild = calculateGraphSize(childNode);
            this.graphSize.put(node, graphSizeFromChild+1);
        }
        ans = Math.max(ans,graphSize.get(node));
        return graphSize.get(node);
    }
    
    void init(int nums[]){
        graph = new HashMap<>();
        graphSize = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            graph.put(nums[i], null);
            graphSize.put(nums[i], 0);
        }
    }
    
    public int longestConsecutive(int[] nums) {
        init(nums);
        for(int i = 0;i<nums.length;i++){
            int currNode = nums[i];
            int nextNode = currNode+1;
            if(graph.containsKey(nextNode)){
                if(graph.get(currNode)== null){
                    graph.put(currNode,nextNode);
                }
            }
        }
        for (Integer key : graph.keySet()) {
            calculateGraphSize(key);
        }
        return ans;
    }
}
