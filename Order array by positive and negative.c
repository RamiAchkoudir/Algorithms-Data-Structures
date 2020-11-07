// integers.c

#include <stdio.h>

/*
 Author: Rami Achkoudir
 The comparison method goes through the array and checks if the 
 specific index is a negative number. When encountered, swap with the current index.
 this will put all negaitve integers on the left side and all remaining (positive) on the right side
 To test code, compile using below instructions:
  gcc -o main main.c 
 ./main

*/
int comparison (int arr[], int len) {
    
    int i,j,tmp;
    j = 0;

    /*
    The time complexity for this method is O(N) since the for-loop
    traverses the entire list which is an O(N) operation but the if
    statements do the same number of operations regardless of the input
    */
    
        for(i = 0; i < len; i++) {
            
            if(arr[i] < 0) {
                
                if(i != j) {
                    
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                    
                }
                
                j++;
            }
        }
    
    return 0;
}

void print(int arr[], int len) {
    
    for (int i = 0; i < len; i++) {
        printf("%d ", arr[i]);
    }
    
    printf("\n");
    
}

int main() {
    
    int array[] = {3, -4, 2, 7, -1, 1, -3};
    int len = sizeof(array)/sizeof(array[0]);
    printf("Unordered array: ");
    print(array,len);
    printf("\n");
    comparison(array,len);
    printf("Ordered array: ");
    print(array,len);
    printf("\n");
    
}