class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer>A=new ArrayList<>();
        int index=txt.indexOf(pat);
        while(index!=-1){
            A.add(index+1);
            index=txt.indexOf(pat,index+1);
        }
        return A;
    }
}
