class Solution {
    
    public boolean countSub(long arr[], long n)
    {
       for(int i=0;i<arr.length;i++)
       {
           int left=2*i+1;
           if(left<n)
           { if( arr[left]>arr[i])
               return false;
           }
           int right=2*i+2;
           if(right<n)
           { if( arr[right]>arr[i])
               return false;
           }  
       }
       return true;
     }
}
