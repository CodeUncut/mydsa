class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n){
            if(n==0)return 0;
            int count=1;
            while(n%2==0){
                count++;
                n/=2;
            }
            return count;
    }
}
