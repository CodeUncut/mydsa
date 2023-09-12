class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for(char c: s.toCharArray())
            count[c-'a']++;
        Set<Integer> set = new HashSet();
        int result = 0;
        for(int i = 0; i<26; i++){
           while(count[i]>0 && set.contains(count[i])){
               count[i]--;
               result++;
           }
           set.add(count[i]);
        }
        return result;
    }
}
