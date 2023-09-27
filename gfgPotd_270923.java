class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
         ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = m-1;
        int diff = Integer.MAX_VALUE;
        
        while(left < n && right >= 0)
        {
            int sum = arr[left] + brr[right];
            int currdiff = Math.abs(sum - x);
            
            if(currdiff < diff)
            {
                diff = currdiff;
                list.clear();
                list.add(arr[left]);
                list.add(brr[right]);
            }
            
            if(sum < x)
            {
                left++;
            }
            else{
                right--;
            }
        }
        
        return list;
    }
}
