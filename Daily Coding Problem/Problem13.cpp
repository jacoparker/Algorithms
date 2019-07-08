// Good morning! Here's your coding interview problem for today.
// This problem was asked by Amazon.
// Given an integer k and a string s, find the length of the longest substring
// that contains at most k distinct characters.
// For example, given s = "abcba" and k = 2, the longest substring with k
// distinct characters is "bcb".

#include <iostream>
#include <string>
using namespace std;


string findLongestSubString(string s, unsigned int k)
{
    if (k >= s.size()) return s;

    
}

int main(int argc, char **argv)
{
    if (argc < 3)
    {
        cout << "Usage: p13 <string> <int>" << endl;
        exit(1);
    }

    string str (argv[1]);
    unsigned int k = atoi(argv[2]);  // assume given a valid int
    string result = findLongestSubString(str, k);
}
