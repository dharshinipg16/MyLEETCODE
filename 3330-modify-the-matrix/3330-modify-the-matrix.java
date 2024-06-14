class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<col;i++)
        {
            int cmax=0;
            for(int j=0;j<row;j++)
            {
                cmax=Math.max(matrix[j][i],cmax);

            }
            for(int j=0;j<row;j++){
            if(matrix[j][i]==-1)
            {
                matrix[j][i]=cmax;
            }
            }
        }
        return matrix;
    }
}