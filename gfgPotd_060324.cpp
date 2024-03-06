class Solution
{
    public:
        vector <int> search(string pattern, string text)
        {
            //code here.
            int p=pattern.size();
            int t=text.size();
            
            vector<int>len;
            for(int i=0;i<t;i++){
                bool flag=true;
                int j=i;
                for(int k=0;k<p;k++){
                    if(pattern[k]!=text[j]){
                        flag=false;
                        break;
                    }
                    j++;
                }
                if(flag){
                    len.push_back(i+1);
                }
            }
            return len;
        }
     
};
