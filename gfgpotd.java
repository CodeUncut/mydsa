class Solution {
public:
    static bool cmp(const pair<int,int> &p1, const pair<int,int> &p2)
    {
        if(p1.first== p2.first) return p1.first < p2.first;
        return p1.first < p2.first;
    }

    int buyMaximumProducts(int n, int k, int price[]){
        //Write your code here
        vector<pair<int,int>>v;
        for( int i=0; i<n; i++)
        {
            v.push_back({price[i], i+1});
        }
        sort(v.begin(), v.end(), cmp);
        
        int count=0;
        int paisa=k;
        
        // for( int i=0; i<n; i++)
        // {
        //     cout<<v[i].first<<", "<<v[i].second<<endl;
        // }
        
        for( int i=0; i<n ; i++)
        {   
            int stock_val=v[i].first * v[i].second;
            if( paisa >= (stock_val) )
            {
                count+= v[i].second;
                paisa-=stock_val;
              // cout<<"maine liya "<<v[i].first<<"wala, "<<"aur "<<v[i].second<<endl;
                continue;
            }
            else if( paisa >= (v[i].first))
            {   
                int val= v[i].first;
                int it=1;
                while(paisa >= val)
                {
                    count+=1;
                    paisa-=v[i].first;
                   //cout<<"maine liya "<<v[i].first<<"wala, "<<"aur "<<it<<endl;
                    it++;
                }
            }
        }
        return count;
    }
};
