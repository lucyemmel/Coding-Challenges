#pragma once

#include <string>
#include <iostream>
#include <memory>

class LL_Member {
public:
    int value;
    std::shared_ptr<LL_Member> next;

    LL_Member(int val);
};

class MyLinkedListInt {
public:
    std::shared_ptr<LL_Member> start;
    std::shared_ptr<LL_Member> end;
    unsigned long length;

    // insert the given number at the end of the list
    void insert(int val);

    // returns true if the element was found
    bool includes(int val);

    // returns true if the element was found and removed
    bool remove(int val);

    std::string toString();

    MyLinkedListInt();
};

