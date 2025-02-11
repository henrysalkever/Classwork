#include <string> 
#include <vector>
using namespace std;

class Node; //forward declaration, which means you are telling the compiler 
// there will be a class named node later 

//creates another name (alias) for Node*

typedef Node* NodePtr;

//these two lines are equivalent 
Node* ptr1;  //using regular pointer declaration 
NodePtr ptr2; //using the typedef alias 


//a helper class for Node representing a single arc out of a node 

class Arc {
    public: 
        string label;
        NodePtr next;
};

// represents a state in an FSA 
class Node{
    public: 
        Node(void);
        NodePtr match(string label); //returns node target for given label
        NodePtr update(string label); //makes new node target for given label
        bool accept; //is this an accept node 
        bool initial; //is this the initial node  

    private:
        vector<Arc> arcs; //the arcs going out of a node 
};

class FSA {
    public:
        FSA(); // makes empty FSA to then add with update 
        char sep; //what character to split input at 

        /* turns into into a vector key using sep as a separator*/
        bool accept(string input); //test if input is accepted 
        void update(string input); //add to FSA to make input be accepted 

        private: 
            vector<NodePtr> initial_states;
            vector<string> key;
            void set_key_from_string(string in); //set key by splitting string at the sep char 

};

