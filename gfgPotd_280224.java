class Solution{
    int DivisibleByEight(String s){
        //code here
        //
        //int temp = 0;
        if(s.length()<=3) {
          int temp = Integer.parseInt(s);
          if(temp%8==0) return 1;
        }
        
        else {
            String str = s.substring(s.length()-3);
            int p = Integer.parseInt(str);
            if(p%8==0) return 1;
        }
        return -1;
    }
}
