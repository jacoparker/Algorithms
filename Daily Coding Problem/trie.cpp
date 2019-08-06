#include <vector>
#include "trie"
#include <string>

using namespace std;

trie::trie(vector<string> *dict)
{
    this->node = new node(NULL, new vector<char>());  // create root node
}

trie::~trie()
{

}

trie::add(string word)
{

}

trie::lookUp(string word)
{

}
