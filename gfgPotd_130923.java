class Solution{
    static String findLargest(int N, int S){
        // code here
        int maxPossibleSum = N*9;
        if(S > maxPossibleSum){
            return "-1";
        }
        if(S == 0 && N > 1){
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        
        while(N > 0){
            int digit = Math.min(S, 9);
            sb.append(digit);
            S-= digit;
            N--;
        }
        
        return sb.toString();
    }
}
