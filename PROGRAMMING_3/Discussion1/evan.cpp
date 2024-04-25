#include <iostream>

int main() {
  int* ptr = nullptr; // Null pointer
  *ptr = 5; // Null pointer dereference vulnerability
  return 0;
}