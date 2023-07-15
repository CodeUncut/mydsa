class Solution
{
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here 
        if(s.size()==(sizeOfStack+1)/2){
            s.pop();
            return;
        }
        int x = s.peek();
        s.pop();
        deleteMid(s,sizeOfStack);
        s.push(x);
    } 
}
