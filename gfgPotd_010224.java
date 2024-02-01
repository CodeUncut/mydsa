class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        
        int[] alpha = new int[26];
        s = s.toLowerCase();
        int len = s.length();
        
        for (int i =0; i<len;i++){
            if(Character.isAlphabetic(s.charAt(i)))
            alpha[s.charAt(i)-'a']++;
        }
        for(int i=0; i<26;i++){
            if(alpha[i]==0)
                return false;
        }
        return true;
    }
}
