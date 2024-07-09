double averageWaitingTime(int** customers, int customersSize, int* customersColSize) {
    double ans = 0;
    double temp = customers[0][0];
    
    double wait = 0;
    for (int i=0 ; i<customersSize ; i++) {
        
        if (temp>=customers[i][0]){
            temp+=customers[i][1]; //end time
            wait = temp - customers[i][0];
        }else{
            temp = customers[i][0]+customers[i][1];
            wait = temp - customers[i][0];
        }
        // printf("temp =  %.5f\n",temp);
        // printf("wait = %.5f\n",wait);
        ans+=wait;
        // printf("ans = %.5f\n",ans);
    }
    //printf("%.5f\n",ans);
    return (ans/customersSize);
}