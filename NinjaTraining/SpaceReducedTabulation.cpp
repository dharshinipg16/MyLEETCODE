int ninjaTraining(int n, vector<vector<int>> &points)
{
    //vector<vector<int>> dp(n,vector<int>(4,0));
    vector<int> prev (4,0);
    prev[0]=max(points[0][1],points[0][2]);
    prev[1]=max(points[0][0],points[0][2]);
    prev[2]=max(points[0][1],points[0][0]);
    prev[3]=max(points[0][0],max(points[0][1],points[0][2]));
    
    for (int day=1;day<n;day++) {
        vector<int> temp (4,0);
        for (int last = 0;last<4;last++) {
            temp[last]=0;
            for (int task = 0;task<3;task++) {
                if (task!=last) {
                    int point = points[day][task] +prev[task];
                    temp[last]=max(point,temp[last]);
                }
            }
        }
        prev=temp;
    }
    return prev[3];
}
