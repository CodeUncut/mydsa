class Solution
{
    //Function to return list containing first n fibonacci numbers.
   public static long[] printFibb(int n) 
    {
        long[] k = new long[n];
        long n1 = 0,n2 = 1,sum = 0;
        k[0] = 1;
        for(int i = 1;i<n;i++){
            sum = n1+n2;
            k[i] = sum;
            n1 = n2;
            n2 = sum;
        }
        return k;
    }
}
