class  Solution
{
   
    void shuffleArray(long arr[], int n)
    {
         int i = n/2-1;
          for(int j=n-1; j>=n/2; j--, i--)
          {
              arr[j] <<= 10;
              arr[j] |= arr[i]; 
          }
          i=0;
          for(int j=n/2; j<n; j++)
          {
              long n1=arr[j]&1023;
              long n2=arr[j]>>10;
              arr[i]=n1;
              arr[i+1]=n2;
              i+=2;
          }
    }
}
