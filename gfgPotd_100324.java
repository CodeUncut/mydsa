class Solution {
    String removeDuplicates(String str) {
        String ans= "";
        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(!ans.contains(ch+""))ans+=ch;
        }
        return ans;
    }
}
