class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<=1;i++)
        {
            for(int j=0;j<=1;j++)
            {
                if(check(grid,i,j))
                {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean check(char grid[][], int i, int j)
    {
        int count=0,count1=0;
        for(int i1=i;i1<i+2;i1++)
        {
            for(int j1=j;j1<j+2;j1++)
            {
                if(grid[i1][j1] == 'B')
                {
                    count++;
                }
                else
                {
                    count1++;
                }
            }
        }
        return count<=1 || count1<=1;
    }
}