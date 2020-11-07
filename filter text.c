// Written by Rami Achkoudir
// Filter out non-alphabetic characters
#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main() {
    
    /*
      Read and write the textfile.
    */
    FILE *input, *output;

	//read file, write file to new text file
    input = fopen("C:\\Users\\usr-ramach01\\Desktop\\test2.txt", "r");
    output = fopen("C:\\Users\\usr-ramach01\\Desktop\\test3.txt", "w");
    
    
    //the isalpha() method writes over all non-alphabetic characters with a blank space
   
    char c;
    while ((c = getc(input)) != EOF) {
        
        if (!isalpha(c) && c != ' ' && c != '\n') {
            c = ' ';
        }
        
        fputc(c,output);
    }
    
    fclose(input);
    fclose(output);
    
    return 0;
}
