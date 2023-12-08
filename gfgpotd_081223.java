class Solution
{
    public int minNumber(int arr[], int N)
    {
        int sum=0;
        for(int i=0;i<N;i++)
        {
            sum+=arr[i];
        }
        if(sum==1||sum==2||sum==3||sum==5||sum==7) return 1;
        if(prime(sum)==1) return 0;
        int temp=sum;
        for(;;){
            temp++;
            if(prime(temp)==1) return (temp-sum);
        }
    }
    
    public static int prime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){ return 0;}            
        }
        return 1;
    }
}
