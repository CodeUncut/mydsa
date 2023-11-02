class Solution {
    int minDist(int a[], int n, int x, int y) {
        // code here
        int xindx = -1 , yindx = -1;
        int ans = Integer.MAX_VALUE ;
        boolean flag1 = false , flag2 = false;
        for(int i=0;i<n;i++){
            if(a[i]==x){
                xindx = i;
                flag1 = true;
            }
            
            if(a[i]== y){
                yindx = i;
                flag2 = true;
            }
            
            if(flag1 ==true && flag2 == true){
                ans = Math.min(ans ,Math.abs( yindx-xindx));
            }
        }
        
        if(flag1 ==false || flag2 == false){
            return -1;
        }
        
        return ans;
        
    }
}
