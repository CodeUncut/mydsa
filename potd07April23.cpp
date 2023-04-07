Add Minimum Characters

Given a string str, find the minimum characters to be added at front of the string to make it a palindrome.


Example 1:

Input:
str = ABCD
Output: 3
Explanation: The resultant string 
after adding 3 characters is DCBABCD.
The minimum possible answer is 3.

//Answer:

class Solution{   
public:
    bool isPalindrome(string s)
    {
        int i =0, j =s.size()-1;
        while(i<j)
        {
            if(s[i]!=s[j])
            return false;
            else
            i++;
            j--;
            
        }
        return true;
    }
    int addMinChar(string str){    
        //code here
        if(isPalindrome(str) == true)
        return 0;
        
        for(int i = str.length()-1; i>=0;i--)
        {
            if(isPalindrome(str.substr(0, i)))
            {
                return str.length()-i;
            }
        }
        
        return str.length();
        
    }
};


kya google me kaam karnee wale bhi google karte hai?