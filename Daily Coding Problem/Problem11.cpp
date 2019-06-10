// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Twitter.
//
// Implement an autocomplete system. That is, given a query string s and a set
// of all possible query strings, return all strings in the set that have s
// as a prefix.
//
// For example, given the query string de and the set of strings
// [dog, deer, deal], return [deer, deal].
//
// Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

#include <iostream>
#include <string>
#include <map>
using namespace std;

class trie
{
    struct trie_node
    {
private:
        char letter;
        map<char, trie_node *> *children;
public:
        // getters
        char getLetter() { return this->letter; }
        map<char, trie_node *> *getChildren() { return this->children; }
        trie_node *getChild(char c)
        {
            trie_node *result = this->children->find(c);
            return (result == children->end() ? NULL : result);
        }

        // setters
        void setLetter(char letter) { this->letter = letter; }
        void setChildren(map<char, trie_node *> *children) { this->children = children; }
        trie_node *addChild(char letter)
        {
            if (children->find(letter) == children->end())
            {
                trie_node *new_child = new trie_node{letter, NULL};
                children->insert(pair<char, trie_node*>(letter, new_child));
                return new_child;
            }
            return NULL;  // TODO return the correct child if already present
        }
    };

private:
    trie_node *root;  // usually does not have data

public:
    trie() {}

    trie_node *getRoot() { return this->root; }

    // solves the problem at hand
    vector<string> *getPossibleWords(string prefix)
    {

    }

    // mainly for testing purposes
    boolean lookup(string word)
    {
        trie_node *curr = getRoot();
        for (char curr_c: word)
        {
            if ((curr = curr->getChild(curr_c) == NULL)
                return false;
        }
        return true;
    }

    // add a new word to our dictionary
    void add(string word)
    {
        trie_node *curr = getRoot(), *tmp;
        for (char curr_c: word)
        {
            if ((tmp = curr->getChild(curr_c) == NULL)
                curr = curr->addChild(curr_c);
            else curr = tmp;
        }
    }
};


int main(int argc, char *argv[])
{

}
