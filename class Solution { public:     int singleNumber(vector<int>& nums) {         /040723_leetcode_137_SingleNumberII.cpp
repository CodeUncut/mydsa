class Solution {
public:
    int singleNumber(vector<int>& nums) {
        //using XOR + AND combination
        
        int ones =0;
        int twos = 0;
        for(auto ele: nums){
            ones = (ones^ele) &(~twos);
            twos = (twos^ele) &(~ones);
        }
        return ones;
    }
};
