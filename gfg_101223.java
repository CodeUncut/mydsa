class Solution{
   static boolean findsum(int arr[],int n) {
        Map<Integer, Boolean> mp = new HashMap<>();
        mp.put(0, true);
        
        int sum = 0;
        
        for(int it: arr) {
            sum += it;
            
            if(mp.containsKey(sum)) 
                return true;
            else 
                mp.put(sum, true);
        }
        
        return false;
    }
}
