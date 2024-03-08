class Solution {
    boolean sameFreq(String s) {
        int M = 26; // size of hash map for all 26 letters
        int l = s.length();
        
        // Fill frequency array
        int[] freq = new int[M];
        for (int i = 0; i < l; i++)
            freq[getIdx(s.charAt(i))]++;
        
        // If all frequencies are same, then return true
        if (allSame(freq, M))
            return true;
        
        // Try decreasing frequency of all characters by one
        // and then check equality of all non-zero frequencies
        for (char c = 'a'; c <= 'z'; c++) {
            int i = getIdx(c);
            
            // Check character only if it occurs in s
            if (freq[i] > 0) {
                freq[i]--;
                
                // Initialize same variable
                int same = freq[i];
                
                if (allSame(freq, M))
                    return true;
                
                freq[i]++;
            }
        }
        
        return false;
    }
    
    // Utility method to get index of character ch in lower alphabet characters
    int getIdx(char ch) {
        return (ch - 'a');
    }
    
    // Returns true if all non-zero elements values are same
    boolean allSame(int[] freq, int N) {
        int same = 0;
        
        // Get first non-zero element
        int i;
        for (i = 0; i < N; i++) {
            if (freq[i] > 0) {
                same = freq[i];
                break;
            }
        }
        
        // Check equality of each element with variable same
        for (int j = i + 1; j < N; j++)
            if (freq[j] > 0 && freq[j] != same)
                return false;
        
        return true;
    }
}
