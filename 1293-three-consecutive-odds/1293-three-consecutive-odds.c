bool threeConsecutiveOdds(int* arr, int arrSize) {
    int count=0;
    for (int i=0;i<arrSize;i++) {
        if (arr[i]%2==1){
            count+=1;
        }else{
            count=0;
        }
        if (count==3) {
            return true;
        }
    }
    return false;
}