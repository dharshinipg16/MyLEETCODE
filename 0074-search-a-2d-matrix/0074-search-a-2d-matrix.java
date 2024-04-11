class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] i : matrix) {
            if (i[0]<=target && i[i.length-1]>=target){
                int[] nums=i;
                int start = 0;
                int end = nums.length - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (nums[mid] == target) {
                        return true;
                    } else if (nums[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}






// class Solution:
//     def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
//         for i in matrix:
//             if (i[0]<= target and i[-1]>=target):
//                 if target in i:
//                     return True
//         return False