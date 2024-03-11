class Solution{
public:	
	
	int countPairs(vector<vector<int>> &mat1, vector<vector<int>> &mat2, int n, int x)
	{
	    // Your code goes here
	    map<int,int> mp;
	    vector<pair<int,int>> vect;
	    
	    for(int i = 0 ; i < n; i++){
	        for(int j = 0 ; j < n ; j++){
	            mp[mat2[i][j]]++;
	        }
	    }
	    
	    for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j  < n; j++){
                int currentValue = mat1[i][j];
                int requiredValue = x-currentValue;
            
                if(mp.find(requiredValue) != mp.end()){
                    //the element is present
                    int first = currentValue;
                    int second = requiredValue;
                
                    vect.push_back(make_pair(first,second));
                
                    mp[requiredValue]--;
                }
            }
        }
        
        return vect.size();
	    
	    
	    
	}
};
