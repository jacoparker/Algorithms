// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Google.
//
// An XOR linked list is a more memory efficient doubly linked list.
// Instead of each node holding next and prev fields, it holds a field named
// both, which is an XOR of the next node and the previous node. Implement an
// XOR linked list; it has an add(element) which adds the element to the end,
// and a get(index) which returns the node at index.
//
// If using a language that has no pointers (such as Python), you can assume
// you have access to get_pointer and dereference_pointer functions that
// converts between nodes and memory addresses.

#include <iostream>
using namespace std;

template <class T>
class XORLinkedList
{
private:

    template <class E>
    struct Node
    {
        E data;
        Node<E> *both;
public:
        /*** Getters ***/
        E getData() { return this->data; }
        Node<E> *getBoth() { return this->both; }

        /*** Setters ***/
        void setData(E data) { this->data = data; }
        void setBoth(Node<E> *prev, Node<E> *next)
        {
            this->both = (Node<E> *)((unsigned int)prev ^ (unsigned int)next);
        }
    };

private:
    Node<T> *head, *tail;
    unsigned int numNodes;

public:
    /*** Constructors ***/
    XORLinkedList(){ setHead(NULL); setTail(NULL); setNumNodes(0); }

    /*** Destructors ***/
    ~XORLinkedList()
    {
        Node<T> *curr, *next, *prev=NULL;
        curr = getHead();
        while (curr != NULL)
        {
            next = (Node<T> *)((unsigned int)prev ^ (unsigned int)curr->getBoth());
            prev = curr;
            delete curr;
            curr = next;
        }
    }

    /*** Getters ***/
    Node<T> *getHead() { return this->head; }
    Node<T> *getTail() { return this->tail; }
    unsigned int getNumNodes() { return this->numNodes; }

    /*** Setters, updating functions, etc ***/
    void setTail(Node<T> *newTail) { this->tail = newTail; }
    void setHead(Node<T> *newHead) { this->head = newHead; }
    void setNumNodes(unsigned int numNodes) { this->numNodes = numNodes; }
    void incNumNodes() { this->numNodes += 1; }

    void add(T data)
    {
        Node<T> *node = new Node<T>();
        node->setData(data);
        if (getHead() == NULL)
        {
            setHead(node);
            setTail(node);
        }
        else
        {
            Node<T> *tmp = getTail();
            tmp->setBoth(tmp->getBoth(), node);
            node->setBoth(tmp, NULL);
            setTail(node);
        }
        incNumNodes();
    }

    Node<T> *get(int index)
    {
        Node<T> *curr = getHead(), *prev = NULL, *temp;
        for (int i=1; i<=index; i++)
        {
            temp = curr;
            if (curr != NULL)
            {
                curr = (Node<T> *)((unsigned int)prev ^ (unsigned int)curr->getBoth());
                prev = temp;
            }
            // return NULL if out of bounds
            else return NULL;
        }
        return curr;
    }
};


/*** Driver/Test program for above data structure ***/
int main()
{
    XORLinkedList<int> *list = new XORLinkedList<int>();

    // add some data
    for (int i=0; i<=19; i++)
        list->add(i);

    // test whether data is there and retrieved properly
    for (int i=0; i<=19; i++)
        cout << "Data at index " << i << ": " << list->get(i)->getData() << endl;

    delete list;
}
