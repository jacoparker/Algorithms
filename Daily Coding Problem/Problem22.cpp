// Good morning! Here's your coding interview problem for today.
// This problem was asked by Microsoft.
// Given a dictionary of words and a string made up of those words (no spaces),
// return the original sentence in a list. If there is more than one possible
// reconstruction, return any of them. If there is no possible reconstruction,
// then return null.
// For example, given the set of words 'quick', 'brown', 'the', 'fox', and the
// string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
// Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the
// string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or
// ['bedbath', 'and', 'beyond'].

#include "trie.h"
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class solution
{
private:
    trie *trie;
    vector<string> *dictionary;

public:
    solution() { trie = NULL; dictionary = NULL; }
    ~solution() { delete trie; }

    static string* findSentence(vector<string> dictionary, string word)
    {
        if (trie == NULL)
            trie = new trie(dictionary);
        else if (dictionary != this.dictionary)
        {
            trie = new trie(dictionary);
            this.dictionary = dictionary;
        }

        // core logic - trie is set up, now construct a sentence
        string sentence();
        

        return NULL;
    }
};

int main()
{
    string word ("thequickbrownfox");
    vector<string> dictionary({"quick", "brown", "fox", "the"});
    solution.findSentence(dictionary, word);
    for (auto itr = dictionary.begin(); itr < dictionary.end(); itr++)
        cout << *itr << endl;
}
