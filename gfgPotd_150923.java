static int solve(int indx, int arr[],int N ,int terget,int dp[][]){
        //base case
        if(indx>=N){
            return 0;
        }
        if(terget<0){
            return 0;
        }
        if(terget==0){
            return 1;
        }
        if(dp[indx][terget]!=-1){
             return dp[indx][terget];
        }
        int incl=solve(indx+1,arr,N,terget-arr[indx],dp);
        int excl=solve(indx+1,arr,N,terget,dp);
        int ans=(incl + excl);   // num of correct Possible result can be greater than 1 .
        if(ans>=1){
           return  dp[indx][terget]=1; 
        }
        return  dp[indx][terget]=0;
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i];
        }
        if(sum%2!=0){
            return 0;
        }
        int tergt=sum/2;
        int dp[][]=new int[N][tergt+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        } 
        
        return solve(0,arr,N,tergt,dp);
       
    }
