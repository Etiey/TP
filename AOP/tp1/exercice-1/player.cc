#include <string.h>
#include <iostream>

class player {
public:
    std::string name_;
    unsigned age();
    player::player(const std::string& name, unsigned age);
    void printmessage() {
        std::cout << "Hello world\n";
    }
};

int main() {
    player pl;
    pl.printmessage();
    return 0;
}
