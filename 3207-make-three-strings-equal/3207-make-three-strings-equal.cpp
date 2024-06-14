#pragma GCC optimize("O3")
class Solution {
public:
    int findMinimumOperations(string s1, string s2, string s3) {
        int n1=s1.size(), n2=s2.size(), n3=s3.size();
        int n=min({n1, n2, n3}),i=0;
        #pragma unroll
        while(i<n && s1[i]==s2[i] && s2[i]==s3[i])
            i++;
        if (i==0) return -1;
    //    cout<<n1<<","<<n2<<","<<n3<<",i="<<i<<endl;
    //    cout<<n1+n2+n3-3*i;
        return n1+n2+n3-3*i;
        
    }
};
auto init = []()
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 'c';
}();