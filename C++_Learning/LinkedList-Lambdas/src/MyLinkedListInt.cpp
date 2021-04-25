#include "MyLinkedListInt.h"

#include <memory>
#include "utils.h"

LL_Member::LL_Member(int val) {
    this->value = val;
    this->next = nullptr;
}

MyLinkedListInt::MyLinkedListInt() {
    this->start = nullptr;
    this->end = nullptr;
    this->length = 0;
}

void MyLinkedListInt::insert(int value) {
    if (!this->start) {
        this->start = std::make_shared<LL_Member>(value);
        this->end = this->start;
    } else {
        std::shared_ptr<LL_Member> old_end = this->end;
        this->end = std::shared_ptr<LL_Member>(new LL_Member(value));
        old_end->next = this->end;
    }
    this->length++;
}

bool MyLinkedListInt::remove(int val) {
    std::shared_ptr<LL_Member> current = this->start;
    std::shared_ptr<LL_Member> previous = nullptr;
    for (unsigned long i = 0; i < this->length; i++) {
        if (current->value == val) {
            // check whether list holds more than one element
            if (this->length > 1) {
                if (previous) {
                    previous->next = current->next;
                    // update end pointer if necessary
                    if (current == this->end)
                        this->end = previous;
                } else {
                    // removing first element
                    this->start = this->start->next;
                }
            } else
                this->start = nullptr;

            this->length--;
            return true;
        }
        previous = current;
        current = current->next;
    }
    return false;
}

bool MyLinkedListInt::includes(int val) {
    // just a local variable that doesn't need to be unique_ptr
    LL_Member *current = this->start.get();
    for (unsigned long i = 0; i < this->length; i++) {
        if (val == current->value)
            return true;
        current = current->next.get();
    }
    return false;
}

std::string MyLinkedListInt::toString() {
    std::string str = "[";
    LL_Member *current = this->start.get();
    for (unsigned long i = 0; i < this->length; i++) {
        str += std::to_string(current->value);
        if (i != this->length - 1)
            str += ",";
        current = current->next.get();
    }
    str += "]";
    return str;
}

