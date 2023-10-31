class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        // code here
        int j = 0;
        for(int i = 0; i<n;i++){
            if(arr[i] !=0){
                arr[j] = arr[i];
                j++;
            }
        }
        while(j<n){
            arr[j]=0;
            j++;
        }
    }
}
