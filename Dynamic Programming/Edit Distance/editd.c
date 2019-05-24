#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "editd.h"

int **table = NULL;  // TODO change this so that the user must give the table and perform all memory allocation/deallocation

/**
 * Retrace the edit distance steps and print the operations needed
 * transform str1 into str2. Goes in reverse order from the end of
 * the strings to the beginning.
 * 
 * TODO print the current status of the string
 */ 
void backtrack(char *str1, char *str2)
{
    if (table == NULL) {
        printf("ERROR: Levenshtein distance has not been calculated yet. Exiting...\n");
        exit(1);
    }

    int i = strlen(str1);
    int j = strlen(str2);

    int result = table[i][j];

    while (result != 0 && i > 0 && j > 0) {
        if (str1[i-1] == str2[j-1]) {
            i -= 1;
            j -= 1;
        } else {
            if (table[i][j-1] == result-1) {
                j -= 1;
                printf(" - Insert %c\n", str2[j]);
            } else if (table[i-1][j-1] == result-1) {
                i -= 1;
                j -= 1;
                printf(" - Replace %c with %c\n", str1[i], str2[j]);
            } else {
                i -= 1;
                printf(" - Delete %c\n", str1[i]);
            }
            result -= 1;
        }
    }

    if (i != 0) {
        while (result != 0) {
            i -= 1; result -= 1;
            printf(" - Delete %c\n", str1[i]);
        }
    } else if (j != 0) {
        while(result != 0) {
            j -= 1; result -= 1;
            printf(" - Insert %c\n", str2[j]);
        }
    }
}

/**
 * Small helper for finding the min value of three element
 * array. Hardcoded array size as this should only be used
 * by the lev function.
 */
int findmin(int *arr)
{
    int min_val = arr[0];
    for (int i=1; i<3; i++) {
        if (arr[i] < min_val)
            min_val = arr[i];
    }
    return min_val;
}

/**
  * compute levenshtein distance of two strings
  * otherwise known as edit distance
  */
int lev(char *str1, char *str2) 
{
    int len1 = strlen(str1);
    int len2 = strlen(str2);

    table = malloc(sizeof(int*)*(len1+1));
    for (int i=0; i<=len1; i++)
        table[i] = malloc(sizeof(int)*(len2+1));

    for ( int i=0; i<=len1; i++ ) {
        table[0][i] = i;
        table[i][0] = i;
    }

    for ( int i=1; i<=len1; i++ ) {
        for ( int j=1; j<=len2; j++ ) {
            if (str1[i-1] == str2[j-1]) {
                table[i][j] = table[i-1][j-1];
            } else {
                int tmp_arr[3] = {
                    table[i][j-1], 
                    table[i-1][j-1], 
                    table[i-1][j]
                };
                table[i][j] = findmin(tmp_arr) + 1;
            }
        }
    }
    return table[len1][len2];
}


int main(int argc, char *argv[]) 
{
    if (argc != 3) {
        printf("Usage: editd <str1> <str2>");
        exit(1);
    }

    int result = lev(argv[1], argv[2]);
    printf("Edit Distance: %d\n", result);
    printf("Printing steps: \n");
    backtrack(argv[1], argv[2]);
}
