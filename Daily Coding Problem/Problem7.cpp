// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Facebook.
//
// Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
//  count the number of ways it can be decoded.
//
// For example, the message '111' would give 3, since it could be decoded as
//  'aaa', 'ka', and 'ak'.
//
// You can assume that the messages are decodable. e.g. '001' is not allowed.

#include <iostream>
#include <fstream>
#include <string>
#include <regex>
using namespace std;


int calc_decode_possibilities_helper(string& buf, int index)
{
    if ((unsigned int)index >= buf.length()) return 1;
    else if ( (unsigned int)(index+1) < buf.length() &&  stoi(buf.substr(index, 2)) < 27)
        return calc_decode_possibilities_helper(buf, index+1)
                + calc_decode_possibilities_helper(buf, index+2);
    else return calc_decode_possibilities_helper(buf, index+1);
}

int calc_decode_possibilities(string& buf)
{
    cout << "The string data: " << buf << endl;
    return calc_decode_possibilities_helper(buf, 0);
}

int handle_input(string& buf)
{
    regex e ("[^0-9]+");
    smatch m;
    getline(cin, buf);
    if (regex_search(buf, m, e))
        return 1;
    return 0;
}

int parse(string& filename, string& buf)
{
    // TODO ensure good data like we do with handle_input
    buf = "";
    string line;
    ifstream data_file (filename);
    if (data_file.is_open())
    {
        while (getline(data_file, line))
            buf += line;  // no line parsing, assume it will be good data
    }

    else return 1;
    return 0;
}


int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        string buf ("");
        if (handle_input(buf) != 0)
        {
            cout << "Invalid input. Exiting..." << endl;
            exit(1);
        }
        int result = calc_decode_possibilities(buf);
        cout << "There are " << result << " ways to decode this message." << endl;
    }

    else
    {
        for (int i=1; i<argc; i++)
        {
            string filename = argv[i];
            string data("");
            if (parse(filename, data) != 0)
            {
                cout << "Could not parse " << filename << ". Exiting..." << endl;
                exit(1);
            }
            int result = calc_decode_possibilities(data);
            cout << "There are " << result << " ways to decode " << filename << "." << endl;
        }
    }
}
