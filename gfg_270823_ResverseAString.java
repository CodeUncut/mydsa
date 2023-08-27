class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String res = sb.reverse().toString();
        return res;
    }
}
