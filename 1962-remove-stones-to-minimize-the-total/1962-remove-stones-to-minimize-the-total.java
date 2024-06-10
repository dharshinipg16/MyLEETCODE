class Solution {
    public int minStoneSum(int[] piles, int k) {
        List<Integer> lst = new ArrayList<>();
        int totalsum=0;
        for (int i:piles) {
            lst.add(i);
            totalsum+=i;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(lst.size(),new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        
        pq.addAll(lst);
        
        for (int i=0;i<k;i++) {
            int x = pq.poll();
            int red = x/2;
            // System.out.println(red);
            pq.add(x-red);
            totalsum-=red;
        }
        return totalsum;
    }
}