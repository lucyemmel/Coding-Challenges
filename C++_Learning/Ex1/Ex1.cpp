#include <iostream>
#include "MyLinkedList.h"
#include "Lambdas.h"
#include "utils.h"
#include <string>
#include <vector>
#include <time.h>  
#include <algorithm>

void test() {
    MyLinkedList<int> list{};
    std::vector<int> vec{};
    srand(time(nullptr));
    int values[1000];

    for (int i = 0; i < 1000; i++) {
        values[i] = rand() % 50;
    }

    // filling MyLinkedList
    for (int i = 0; i < 1000; i++) {
        int val = values[i];
        if (!list.remove(val))
            list.insert(val);
    }
    print("List content:");
    print(list.toString());

    //filling normal vector
    for(int i = 0; i < 1000; i++) {
        int val = values[i];

        // search for element and remove if found
        auto it = std::find(vec.begin(), vec.end(), val);
        if (it != vec.end())
            vec.erase(it);
        else {
            vec.push_back(val);
        }
    }
    print("Vector content:");
    std::cout << "{";
    for (int val : vec) {
        std::cout << val;
        // this case only occurs at last element since element values are unique here
        if (val != vec.back())
            std::cout << ',';
    }
    std::cout << "}" << std::endl;

}

int main()
{
    test();
    return 0;
}
