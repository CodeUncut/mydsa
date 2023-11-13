class Solution {
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || 
c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public String sortVowels(String str) {
        char s[] = str.toCharArray();
        int vowelFreq[] = new int[256];
        for(var chr : s){
           if(isVowel(chr)) 
            vowelFreq[chr]++;
        }
        int freqIndx = 0;
        while(freqIndx < 256 && vowelFreq[freqIndx] == 0)freqIndx++;
        for(int strIndx = 0; strIndx < s.length; strIndx++){
            if(isVowel(s[strIndx])){
                s[strIndx] = (char)(freqIndx);
                if(--vowelFreq[freqIndx] == 0)freqIndx++;
            }
            while(freqIndx < 256 && vowelFreq[freqIndx] == 0)freqIndx++;
        }
        return new String(s);
    }
}
