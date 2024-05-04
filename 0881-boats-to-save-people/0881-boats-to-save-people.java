class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left=0;
        int right = people.length - 1;
        int boats = 0;
        while (left<=right) {
            if (people[left]+people[right]  <= limit) {
                boats++;
                left++;
                right--;
            }
            else if (people[right]<=limit) {
                boats++;
                right--;
            }
        }
        return boats;
    }
}