class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length ==2){
            return true;
        }
        
        Arrays.sort(arr);
        int diff = arr[1] -arr[0];
        for(int i=2; i<arr.length;i++)
        {
            int currDiff = arr[i]-arr[i-1];
            if(currDiff != diff){
                return false;
            }
        }
            return true;
    }
}
