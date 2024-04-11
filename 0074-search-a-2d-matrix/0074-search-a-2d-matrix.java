class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] i : matrix) {
            if (i[0]<=target && i[i.length-1]>=target){
                for (int ele: i) {
                    if (ele == target){
                        return true;
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