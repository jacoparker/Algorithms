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
#include <vector>
#include <map>
#include <assert.h>
#include <stack>
using namespace std;

class trie
{
    struct trie_node
    {
private:
        char letter;
        unsigned int level;
        map<char, trie_node *> *children;
public:
        // getters
        char getLetter() { return this->letter; }
        unsigned int getLevel() { return this->level; }
        map<char, trie_node *> *getChildren() { return this->children; }
        trie_node *getChild(char c)
        {
            return (children->find(c) == children->end()) ? NULL : children->at(c);
        }

        // setters
        void setLetter(char letter) { this->letter = letter; }
        void setLevel(unsigned int level) { this->level = level; }
        void setChildren(map<char, trie_node *> *children) { this->children = children; }
        trie_node *addChild(char letter, unsigned int level)
        {
            if (children->find(letter) == children->end())
            {
                trie_node *new_child = new trie_node;
                new_child->setLetter(letter);
                new_child->setLevel(level);
                new_child->setChildren(new map<char, trie_node*>());
                children->insert(pair<char, trie_node*>(letter, new_child));
                return new_child;
            }
            return NULL;  // TODO return the correct child if already present
        }
    };

private:
    trie_node *root;  // usually does not have data

public:
    trie() { root = new trie_node; root->setChildren(NULL); }
    ~trie() {}

    trie_node *getRoot() { return this->root; }

    void initRoot()
    {
        this->root = new trie_node;
        this->root->setChildren(NULL);
    }

    // solves the problem at hand
    vector<string> *getPossibleWords(string prefix)
    {
        trie_node *curr = getRoot();
        vector<string> *possibleWords = new vector<string>();
        string word("");
        for (char curr_c: prefix)
        {
            word = word + curr_c;
            curr = curr->getChild(curr_c);
            if (curr == NULL) return possibleWords;  // return empty list - substring not in trie
        }

        // traverse subtree looking for asterisks
        stack <trie_node *> st;
        st.push(curr);
        while (!st.empty())
        {
            curr = st.top();
            st.pop();
            word = word.substr(0, curr->getLevel()-1) += curr->getLetter();
            if (curr->getChild('*') != NULL)
                possibleWords->push_back(string (word));
            for (auto child = curr->getChildren()->begin(); child != curr->getChildren()->end(); child++)
            {
                if (child->second->getLetter() != '*')
                    st.push(child->second);
            }
        }
        return possibleWords;
    }

    // mainly for testing purposes
    bool lookup(string word)
    {
        trie_node *curr = getRoot();
        for (char curr_c: word)
        {
            if ((curr = curr->getChild(curr_c)) == NULL)
                return false;
        }
        return curr->getChild('*') != NULL;
    }

    // add a new word to our dictionary
    void add(string word)
    {
        unsigned int level = 0;
        trie_node *curr = getRoot(), *tmp;
        for (char curr_c: word)
        {
            level += 1;
            if (curr->getChildren() == NULL)
            {
                map<char, trie_node *> *ptr = new map<char, trie_node*>();
                curr->setChildren(ptr);
                curr = curr->addChild(curr_c, level);
            }
            else if ((tmp = curr->getChild(curr_c)) == NULL)
                curr = curr->addChild(curr_c, level);
            else curr = tmp;
        }
        curr->addChild('*', level);
    }
};


// test out the trie implementation
int main(int argc, char *argv[])
{
    trie *t = new trie();
    t->add("word");
    t->add("words");
    t->add("world");
    t->add("sort");
    t->add("sorting");
    t->add("happy");
    t->add("happening");
    t->add("wonder");
    t->add("wo");
    t->add("will");
    t->add("wouldn't");
    t->add("apple");
    t->add("application");
    t->add("apply");

    cout << "running tests..." << endl << endl;

    assert(t->lookup("word") == true);
    assert(t->lookup("words") == true);
    assert(t->lookup("world") == true);
    assert(t->lookup("sort") == true);
    assert(t->lookup("sorry") == false);

    // first set of tests
    string test_w ("wo");
    vector<string> *result = t->getPossibleWords(test_w);

    cout << "Printing dictionary of possible words for " << test_w << endl;
    for (auto ans: *result) cout << "word: " << ans << endl;
    cout << endl;

    // second set of tests
    string test_w2 ("app");
    result = t->getPossibleWords(test_w2);

    cout << "Printing dictionary of possible words for " << test_w2 << endl;
    for (auto ans: *result) cout << "word: " << ans << endl;
}
