class Solution {
    public List<Integer> findPeaks(int[] mount) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 1 ; i <mount.length-1 ;i++){
            if(mount[i] > mount[i-1] && mount[i] > mount[i+1])
            arr.add(i);
        }
        return arr;
        
    }
}