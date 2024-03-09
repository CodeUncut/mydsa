class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        StringBuilder ResStr = new StringBuilder(s);
        for(int i=0; i<r; i++){
            for(int j=0; j<ResStr.length(); j+=2){
                if(ResStr.charAt(j) == '0'){
                    ResStr.insert(j+1, '1');
                }
                else{
                    ResStr.insert(j+1, '0');
                }
                
                if(j>n){
                    break;
                }
            }
        }
        
        return ResStr.charAt(n);
    }
}
