int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
    int* result = (int*) malloc(sizeof(int)*2);
    result[0]=1;
    result[1]=0;
    int curline = 0;
    int pos = 0;
    // int stringsize = sizeof(s)/sizeof(char);
    while (pos < strlen(s)){
        int val = s[pos]-'a';
        curline+=widths[val];
        if (curline>100){
            result[0]+=1;
            curline=0;
            //do not increment pos;
        }else{
            pos++;
        }
        printf("%d ",curline);
    }
    if (result[0]==0 && widthsSize!=0){
        result[0]=1;
    }
    result[1]=curline;
    *returnSize = 2;
    return result;
}