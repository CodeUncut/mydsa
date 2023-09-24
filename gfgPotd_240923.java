class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int max=arr[0];
        for(int i=0;i<n;i++) {
            max=Math.max(max,arr[i]);
        }
        int[] dup=new int[max+1];
        for(int i=0;i<n;i++) {
            if(++dup[arr[i]] == 2) {
                ans.add(arr[i]);
            }
        }
        Collections.sort(ans);
        if(ans.size()==0) {
            ans.add(-1);
        }
        return ans;
    }
}
