    static int mod = 1000000007;
    static long power(int N,int R)
    {
        //Your code here
       if(R==1)return N%mod;
       long half = power(N,R/2);
       half = (half*half)%mod;
       if(R%2==1)half = (half*N)%mod;
       return half;
    }
