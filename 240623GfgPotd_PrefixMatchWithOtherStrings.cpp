class Solution{   
public:
    int klengthpref(string arr[], int n, int k, string str){    
        if(k>str.length())return 0;
        int ans =0;
        for(int i=0; i<n;i++){
            if(k<=arr[i].length()){
                int j =0;
                while (j<k){
                    if(arr[i][j]!=str[j])break;
                    j++;
                }
                if(j==k)ans++;
            }
        }
        return ans;
    }
};
