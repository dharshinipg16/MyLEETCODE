int compare(const void* a,const void* b) {
    int* inta = *(const int*)a;
    int* intb = *(const int*)b;

    return (inta>intb)-(intb>inta);
}

int maxProfitAssignment(int* difficulty, int difficultySize, int* profit, int profitSize, int* worker, int workerSize) {
    qsort(worker,workerSize,sizeof(int),compare);

    int total = 0;
    for (int w = 0;w < workerSize;w++) {
        int curworker = worker[w];
        int index = 0;
        int maxprofit = 0;
        while (index < difficultySize){
            if (difficulty[index]<=curworker && profit[index]>maxprofit) {
                maxprofit = profit[index];
            }
            index++;
        }
        total+=maxprofit;
    }
    return total;
}