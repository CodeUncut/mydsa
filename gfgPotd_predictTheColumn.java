class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        // code here 
        int maxCount=0;
        int currentCount=0;
        int column=0;
        int i,j;
        
        for(i=0;i<N;i++)
        {
            currentCount=0;
            for(j=0;j<N;j++)
            {
                if(arr[j][i]==0)
                {
                    currentCount++;
                }
            }
            
            if(currentCount>maxCount)
            {
                maxCount=currentCount;
                column=i;
            }
        }
        
        if(maxCount==0)
        {
            return -1;
        }else{
            return column;
        }
    }
}
