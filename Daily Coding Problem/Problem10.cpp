// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Apple.
//
// Implement a job scheduler which takes in a function f and an integer n,
// and calls f after n milliseconds.

#include "windows.h"
#include <iostream>
using namespace std;


int schedule(int (*funcPtr)(), unsigned int numMilSec)
{
    Sleep(numMilSec);
    return funcPtr();
}


int main()
{



}
