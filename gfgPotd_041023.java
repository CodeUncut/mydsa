class Solution {
    // Finds decimal value of a given roman numeral
   public int romanToDecimal(String str) {
        // code here
         if(str.equals(""))
            return 0;
        if(str.length()==1){
            return digit(str.charAt(0));
        }
        int num = digit(str.charAt(str.length()-1));
        for(int i = str.length()-2;i>=0;i--){
            int ds = digit(str.charAt(i+1));
            int dm = digit(str.charAt(i));
            if(dm == ds){
                num+=dm;
            }
            if(dm<ds){
                num-=dm;
            }
            if(dm>ds) {
                num+=dm;
            }

        }
        return num;
    }
    
     public static int digit(char ch){
        if(ch=='I')
            return 1;
        if(ch=='V')
            return 5;
        if(ch=='X')
            return 10;
        if(ch=='L')
            return 50;
        if(ch=='D')
            return 500;
        if(ch=='M')
            return 1000;
        if(ch=='C')
            return 100;
        return 0;

    }
}
