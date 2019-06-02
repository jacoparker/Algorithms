#include <vector>
#include <iostream>


using namespace std;

int main() {
	vector<int> *v = new vector<int>({1, 2, 3, 4, 5});

	cout << "Vector contents:" << endl;
	for (auto itr = v->begin(); itr < v->end(); itr++) {
		cout << *itr << endl;
	}
}
