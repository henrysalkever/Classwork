#include <iostream>
#include <string>
using namespace std;

class Person {
   public:
       string name;
       void sayHello() { cout << "Hello, " << name << endl; }
};

int main() {
   // 1. Basic new allocation:
   // Shows how new allocates memory and returns address
   int *ptr = new int;  // Allocates memory for one integer
   // Memory is now reserved but has no defined value yet

   // 2. Float pointer example:
   float *f_ptr;             // Just declares pointer - no memory allocated yet
   f_ptr = new float;        // Now allocates memory for one float
   // At this point, f_ptr contains a memory address
   cout << f_ptr;            // Would print something like 0x7ffeeb3c

   // 3. Working with the pointer:
   float *f_ptr2 = new float;
   *f_ptr2 = 3.141;          // Writes 3.141 to the allocated memory
   float value = *f_ptr2;     // Reads value (3.141) from memory
   cout << *f_ptr2;          // Prints 3.141
   cout << f_ptr2;           // Prints memory address (e.g., 0x7ffeeb3c)

   // 4. Class allocation:
   Person *p_ptr = new Person;  // Allocates memory for entire Person object
   // Memory now exists for both name and age

   // 5. Class pointer access (clunky way):
   (*p_ptr).name = "Alice";     // Clunky way to access member
   (*p_ptr).sayHello();         // Clunky way to call method

   // 6. Arrow operator usage (clean way):
   p_ptr->name = "Alice";       // Clean way to access member
   p_ptr->sayHello();           // Clean way to call method
   // Both do exactly the same as example 5, but more readable

   // Clean up allocated memory
   delete ptr;
   delete f_ptr;
   delete f_ptr2;
   delete p_ptr;

   return 0;
}


