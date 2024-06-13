int minMovesToSeat(int* seats, int seatsSize, int* students, int studentsSize) {
    int compare(const void* a,const void* b) {
        int inta = *(const int*)a;
        int intb = *(const int*)b;
        
        if (inta<intb) return 1;
        else if (inta>intb) return -1;
        else return 0;
    }
    int count = 0;
    qsort(seats,seatsSize,sizeof(seats[0]),compare);
    qsort(students,studentsSize,sizeof(int),compare);
    
    int prevseat = 0;
    int seatcounter = 0;
    int studentcounter = 0;
    while (studentcounter<studentsSize && seatcounter<seatsSize) {
        count+= abs(seats[seatcounter]-students[studentcounter]);
        studentcounter++;
        seatcounter++;
    }
    return count;
}