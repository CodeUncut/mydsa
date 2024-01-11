class Solution {
    public String removeKdigits(String S, int K) {
        int n = S.length();
        StringBuilder result = new StringBuilder();
        
        for (char digit : S.toCharArray()) {
            while (K > 0 && result.length() > 0 && result.charAt(result.length() - 1) > digit) {
                result.deleteCharAt(result.length() - 1);
                K--;
            }
            result.append(digit);
        }
        
        // Remove remaining digits if K is not yet reached
        while (K > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            K--;
        }
        
        // Remove leading zeros
        int startIndex = 0;
        while (startIndex < result.length() && result.charAt(startIndex) == '0') {
            startIndex++;
        }
        
        result.delete(0, startIndex);
        
        // If result is empty, return "0"
        return result.length() == 0 ? "0" : result.toString();
    }
}
