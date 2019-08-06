// Good morning! Here's your coding interview problem for today.
// This problem was asked by Twitter.
// You run an e-commerce website and want to record the last N order ids in a
// log. Implement a data structure to accomplish this, with the following API:
// -	record(order_id): adds the order_id to the log
// -	   get_last(i): gets the ith last element from the log. i is guaranteed
//      to be smaller than or equal to N.
// You should be as efficient with time and space as possible.

#include <iostream>
#include <vector>
#include <stdexcept>

using namespace std;

class Log
{

private:

    vector<int> *log;

public:

    Log() { this->log = new vector<int>; }
    ~Log() { delete this->log; }

    vector<int>* getLog() { return this->log; }

    void record(int order_id)
    {
        log->push_back(order_id);
    }

    int* get_last(unsigned int i)
    {
        if (i > getLog()->size()) return &getLog()->at(0);

        int *arr = (int *)malloc(sizeof(int)*i);
        try
        {
            for (int j=i+1; j>0; j--)
            {
                arr[i-j] = getLog()->at(getLog()->size()-j);
            }
        }
        catch (const out_of_range& oor)
        {
            cout << oor.what() << endl;
            exit(1);
        }
        return arr;
    }
};

int main()
{
    Log l = Log();
    l.record(1);
    l.record(2);
    l.record(3);
    l.record(4);
    l.record(5);
    l.record(6);
    l.record(7);
    l.record(8);
    l.record(9);
    l.record(10);

    int *result = l.get_last(5);
    for (int *ptr = result; ptr < &result[5]; ptr++)
    {
        cout << *ptr << endl;
    }
}
