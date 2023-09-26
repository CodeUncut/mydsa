class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int tar) {
        Arrays.sort(arr);
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int k=j+1,l=n-1;
                while(k<l){
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==tar){
                        ArrayList<Integer> temp=new ArrayList<Integer>(Arrays.asList(arr[i],arr[j],arr[k],arr[l])) ; 
                            if(!ans.contains(temp)) ans.add(temp);
                        k++;
                        l--;
                    }else if(sum>tar) l--;
                    else k++;
                }
            }
        }
            return ans;
        }
    }
