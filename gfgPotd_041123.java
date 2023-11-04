class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        int low=0,high=n-1;
        if(arr[0]==1) return 0;
        while(low<=high){
            int mid=(high+low)/2;
            if(arr[mid]==0&&mid+1<n&&arr[mid+1]==1){
                return mid+1;
            }else if(arr[mid]==0){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
