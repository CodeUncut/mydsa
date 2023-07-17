class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        HashMap<Character, Integer> mapy = new HashMap<>();
        Queue<Character> cutie = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<A.length();i++){
            mapy.putIfAbsent(A.charAt(i),0);
            mapy.put(A.charAt(i), mapy.get(A.charAt(i))+1);
            if(mapy.get(A.charAt(i))==1)cutie.add(A.charAt(i));
            while(cutie.size() !=0 && mapy.get(cutie.peek())>1)cutie.remove();
            if(cutie.size()==0)ans.append("#");
            else ans.append(cutie.peek());
        }
        return ans.toString();
    }
}
