class Solution
{
    String colName (long n)
    {
        // your code here
        StringBuilder sb = new StringBuilder();
        while(n>0){
            long i = (n-1)%26;
            sb.append((char)(i+'A'));
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}
