lass MyStack {
public:
    queue<int> q ; 
    MyStack() {
        
    }
    
    void push(int x) {
// normally in queue insertion from behind but we want inserted element in front 
        q.push(x) ; 
        for (int i = 0 ; i < q.size () -1  ; i++)
        {
            int val = q.front() ; 
            q.pop() ; 
            q.push(val) ;
        }
        
    }
    
    int pop() {
        int temp = q.front() ; 
        q.pop();
        return temp;        
    }
    
    int top() {
        return q.front() ; 
    }
    
    bool empty() {
        return q.empty() ; 
    }
};
