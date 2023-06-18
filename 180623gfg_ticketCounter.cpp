class Solution {
  public:
    int distributeTicket(int N, int K) {
        int i =1, j=N, ans;
        bool a = false;
        // code here
        while(i<=j){
            if(!a){
                i+=K;
                ans=j;
            }else{
                j-=K;
                ans= i;
            }
            a =!a;
        }
        return ans;
    }
};
