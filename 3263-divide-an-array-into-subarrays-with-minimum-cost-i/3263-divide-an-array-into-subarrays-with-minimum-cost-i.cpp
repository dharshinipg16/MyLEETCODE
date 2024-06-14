class Solution {
public:
    int solve(int n,vector<int>arr){
        vector<vector<int>>dp(n+1,vector<int>(4,INT_MAX));
        
        dp[1][1]=arr[1];
        dp[1][2]=INT_MAX;
        dp[1][3]=INT_MAX;
        
//         dp[i][j]=> denote the best ans for dp[i] , when arr is diveded into j parts
        dp[2][1]=arr[1];
        dp[2][2]=arr[1]+arr[2];
        dp[2][3]=INT_MAX;
        
        dp[3][1]=arr[1];
        dp[3][2]=min(arr[3]+dp[2][1],arr[2]+dp[1][1]);
        dp[3][3]=arr[3]+dp[2][2];
        
        cout<<dp[1][1]<<","<<dp[2][2]<<","<<dp[3][3]<<endl;
        int i=4;
        while(i<=n){
            dp[i][1]=arr[1];
            int j=i;
            dp[i][2]=INT_MAX;
            
            while(j>=2){
               
                dp[i][2]=min(dp[i][2],(arr[j]+dp[j-1][1]));
                j--;
            }
            // cout<<"dp[4][2]:"<<dp[4][2]<<endl;
            dp[i][3]=INT_MAX;
            int k=i;
           
            while(k>=3){
                
                dp[i][3]=min(dp[i][3],(arr[k]+dp[k-1][2]));
                k--;
            }
            
            
            
            i++;
        }
        
        // cout<<dp[4][3]<<endl;
        int ans=INT_MAX;
        for(int i=3;i<=n;i++){
           ans=min(ans,dp[i][3]); 
        }
        return ans;
        
    }
    int minimumCost(vector<int>& nums) {
        int n=nums.size();
        vector<int>arr(n+1);
        for(int i=0;i<nums.size();i++){
            arr[i+1]=nums[i];
        }
        return solve(n,arr);
        
    }
};