//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K){
    int i=1, j=N, ans=0;
    boolean a = false;
    while(i<=j){
        if(a ==false){
            i +=K;
            ans =j;
        }else{
            j-=K;
            ans=i;
        }
        a=!a;
    }
    return ans;
}
}
