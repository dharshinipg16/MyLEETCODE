/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int compareTo(const void* first,const void* second) {
    int* a = (int*) first;
    int* b = (int*) second;
    if (*a > *b) {
        return 1;
    }
    else if (*b > *a) {
        return -1;
    }
    else {
        return 0;
    }
}

int* relativeSortArray(int* arr1, int arr1Size, int* arr2, int arr2Size, int* returnSize) {
    int i;
    int j=0;
    int m=0;
    int* result = (int*) malloc(arr1Size*sizeof(int));
    while (j<arr2Size) {
        int temp = arr2[j]; //take an ele from arr2
        int count=0;
        i=0;
        while (i<arr1Size) {  //count the occurances of that ele in arr1
            if (arr1[i]==temp) {
                arr1[i]=-1;
                count++;
            }
            i++;
        }
        int k=0; //for occurance times add it in res
        while (k<count) {
            result[m]=temp;
            m++;
            k++;
        }
        j++;
    }
    int n = m;
    for (i=0;i<arr1Size;i++) {
        if (arr1[i]!=-1){
            result[m]=arr1[i];
            m++;
        }
    }
    qsort((result+n),(arr1Size-n),sizeof(int),compareTo);
    *returnSize=arr1Size;
    return result;
}