// Game Of Subsets

/*
Elena is the topper of the class. Once her teacher asked her a problem. He gave Elena an array of integers of length n. He calls a subset of array arr good if its product can be represented as a product of one or more distinct prime numbers. He asked her to find the number of different good subsets in arr modulo 109 + 7.

As a good friend of Elena help her to solve the problem.

Example 1:

Input:
N: 4
arr: {1,2,3,4}
Output: 6
Explanation: 
The good subsets are:
- [1,2]: product is 2, which is the product of distinct
prime 2.
- [1,2,3]: product is 6, which is the product of 
distinct primes 2 and 3.
- [1,3]: product is 3, which is the product of distinct
prime 3.
- [2]: product is 2, which is the product of distinct
 prime 2.
- [2,3]: product is 6, which is the product of distinct
primes 2 and 3.
- [3]: product is 3, which is the product of distinct
prime 3.
Example 2:

Input:
N : 3
arr : {2, 2, 3}
Output: 5
Explanantion:
The good subsets are : {2}, {2}, {2, 3}, {2, 3}, {3}*/

//Answer:

public int goodSubsets(int[] arr, int n) {
        // Code here
        int mm[]= new int[31];
        mm[2] = 1;
        mm[3] = 2;
        mm[5] = 4;
        mm[6] = 3;
        mm[7] = 8;
        mm[10] = 5;
        mm[11] = 16;
        mm[13] = 32;
        mm[14] = 9;
        mm[15] = 6;
        mm[17] = 64;
        mm[19] = 128;
        mm[21] = 10;
        mm[22] = 17;
        mm[23] = 256;
        mm[26] = 33;
        mm[29] = 512;
        mm[30] = 7;
        int f[] = new int[31];
        int c=0;
        for(int x:arr){
            if(x==1)c++;
            else f[x]++;
        }
        long dp[] = new long[1024];
        int mod = 1000000007;
        dp[0]=1;
        for(int j=2;j<31;j++){
            if(f[j]!=0 && mm[j]!=0){
                for(int i=0;i<1024;i++){
                    if((mm[j]&i)==0){
                        dp[(mm[j]|i)]+=(f[j]*dp[i]);
                        dp[(mm[j]|i)]%=mod;
                    }
                }
            }
        }
        int ans=0;
        for(int i=1;i<1024;i++){
            ans+=dp[i];
            ans%=mod;
        }
        while(c!=0){
            ans*=2;
            ans%=mod;
            c--;
        }
        return ans;
    }