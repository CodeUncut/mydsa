Special Digits

You are given 5 integers - N,A,B,C,D.
Let us say all the integers of length N, having only A or B in their decimal representation are good integers. Also, among all the good integers, all those integers whose sum of digits contains either C or D or both are best integers.
Find the number of best integers of length N. Since the number of best integers can be huge, print it modulo 109+7.
 

Example 1:

Input:
N = 2, A = 1, B = 2, C = 3, D = 5
Output: 
2
Explanation: 
The following are good integers:- 
{ 12 , 22 , 11 , 21 }
And the following are best integers:- 
{ 12, 21 } because sum of digits of 11,22
are 2 and 4, they are not equal to C or D.
Example 2:

Input:
N = 1, A = 1, B = 1, C = 2, D = 3
Output: 
0
Explanation: 
The following are good integers: - { 1 }
Since sum of digits is 1 which is not equal to
C or D, therefore, answer is 0.

//Answer:

const int maxSize = 1e5 + 10;
long long fact[maxSize];
const int mod = 1e9 + 7;

int power(long long n, long long x){
    long long ans = 1;
    
    while(x > 0){
        if(x & 1){
            ans = (ans * n) % mod;
            --x;
        }
        else{
            n = (n * n) % mod;
            x >>= 1;
        }
    }

    
    return ans % mod;
}

bool checker(int n, int c, int d){
    string s = to_string(n);
    
    for(auto i : s){
        if(i - '0' == c or i - '0' == d)
            return 1;
    }
    
    return 0;
}

int ncr(long long n, long long r){
    
    long long ans = fact[n];
    ans = (ans * power(fact[r], mod - 2)) % mod;
    ans = (ans * power(fact[n - r], mod - 2)) % mod;

    return ans % mod;
}

class Solution {
  public:
    int bestNumbers(int N, int A, int B, int C, int D) {
        // code here
        
        fact[0] = fact[1] = 1;
        
        for(int i = 2; i < N + 5; i++)
            fact[i] = (i * fact[i - 1]) % mod;
            
        int ans = 0;
        
        if(A == B){
            if(checker(N * A, C, D))
                return 1;
            return 0;
        }
        
        for(int i = 0; i <= N; i++){
            int sum = i * A + (N - i) * B;
            if(checker(sum, C, D)){
                ans = (ans + ncr(N, i)) % mod;
            }
        }
        
        return ans;
    }
};
