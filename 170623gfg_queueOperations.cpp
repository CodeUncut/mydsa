// Helper class Solution to implement 
// insert() and findFrequency()
class Solution{
    public:
    // Function to insert element into the queue
    unordered_map<int, int> map;
    void insert(queue<int> &q, int k){
        
        q.push(k);
        map[k]++;
        
        // Your code here
    }
    
    // Function to find frequency of an element
    // return the frequency of k
    int findFrequency(queue<int> &q, int k){
        // Your code here
        return map[k];
    }
    
};
