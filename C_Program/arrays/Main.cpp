#include <iostream>

// using namespace std;

// create array
void createArray(){
    // Array declaration and initialization
    int arr[] = {1,2,3,4,5,6};
    std::cout << "sizeof(arr) " << sizeof(arr)<<"\n";
    for(int i=0; i< sizeof(arr)/sizeof(arr[0]) ;i++ ){
        std::cout << "array value of index " << i << ": "<< arr[i] <<"\n";
    }

}
int main() {
   //cout << "Hello, World!" << std::endl;
      createArray();
    return 0;
}

