class Solution {
    static int count(int n,int x){
        int c=0,d;
        while(n>0){
            d = n%10;
            if(d==x)
            c++;
            n/=10;
        }
        return c;
    }
    int countX(int L, int R, int X) {
        // code here
        int sum =0;
        for(int i = L+1;i<R;i++){
            sum+= count(i,X);
        }
        return sum;
    }
};
