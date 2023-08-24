/*Given two numbers as strings s1 and s2. Calculate their Product.

Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers. There can be zeros in the begining of the numbers.

Example 1:

Input:
s1 = "0033"
s2 = "2"
Output:
66
Example 2:

Input:
s1 = "11"
s2 = "23"
Output:
253
Your Task: You don't need to read input or print anything. Your task is to complete the function multiplyStrings() which takes two strings s1 and s2 as input and returns their product as a string.

Expected Time Complexity: O(n1* n2)
Expected Auxiliary Space: O(n1 + n2); where n1 and n2 are sizes of strings s1 and s2 respectively.

Constraints:
1 ≤ length of s1 and s2 ≤ 103
  */

Ans.

lass Solution
{
    public String multiplyStrings(String s1,String s2)
    {

int sign1=1;
        int sign2=1;
        if(s1.charAt(0)=='-'){
            s1=s1.substring(1);
            sign1=-1;
        }
        if(s2.charAt(0)=='-'){
            s2=s2.substring(1);
            sign2=-1;
        }
        
        
        int n1 = s1.length();
        int n2 = s2.length();
        int[] result = new int[n1 + n2];
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                 int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(j) - '0';
                int product = digit1 * digit2;
                
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if ((sb.length() == 0 && num == 0)) {
               
            }else{
                sb.append(num);
            }
        }
        
        int resultSign = sign1 * sign2;
        if (sb.length() == 0) {
            return "0";
        } else if (resultSign == -1) {
            sb.insert(0, '-');
        }

        return sb.toString();
        }

}
