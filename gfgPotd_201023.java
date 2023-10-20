class Solution {
    static int isPossible(int N, int arr[]) {
        // code here
          int sum = 0;
        
        for(int val : arr){
            int rem = val % 3;
            sum += rem;
        }
        return sum % 3 == 0 ? 1 : 0;
    }
}
