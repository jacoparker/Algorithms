#include <vector>
#include <string>

using namespace std;

class trie
{
private:
    struct node
    {
        char *value;
        vector<char> *letters;

        setValue(char c) { this->value = c; }
        addLetter(char c) { letters->push_back(c); }
    };

    struct node *n;

public:
    trie(vector<string> *dict);

    ~trie();

    add(string word);

    lookUp(string word);
};
