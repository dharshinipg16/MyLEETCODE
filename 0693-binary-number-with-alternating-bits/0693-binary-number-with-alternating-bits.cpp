class Solution {
public:
vector<int>convert(int n){
    vector<int>ans;
    while(n!=0){
        ans.push_back(n%2);
        n/=2;
    }
    return ans;
}
bool check(vector<int>k){
    int i=0;
    int j=1;
    int e=k.size()-1;
    while(e!=0){
        if(k[i]==k[j]){
            return false;
        }
        i+=1;
        j+=1;
        e-=1;
    }
    return true;
}
    bool hasAlternatingBits(int n) {
        return check(convert(n));
    }
};