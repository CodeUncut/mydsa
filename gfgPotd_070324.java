class Solution {
    static String longestSubstring(String S, int N) {
        // code here
        int i=0,j=0,startingIndex=0,endingIndex=0;
        int len = 1;
        char[] arr = S.toCharArray();
        String output = "";
        boolean flag = false;
        while(j < N && i < N){
            String str = S.substring(i,j+1);
            if(S.substring(j+1,N).indexOf(str) != -1){
                len = Math.max(len,j-i+1);
                startingIndex = i;
                endingIndex = j;
                flag = true;
            }else{
                i++;
            }
            j++;
        }
        if(!flag){
            return "-1";
        }
        return S.substring(startingIndex,endingIndex+1);
    }
};
