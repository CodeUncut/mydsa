class Solution

{

    public List<String> AllPossibleStrings(String s)

    {

        // Code here

        List<String> a = new ArrayList<>();

        int i, j, l =s.length();

        for(i=0;i<l;i++)

        a.add(""+s.charAt(i));

        if(l==1) 

        return a;

        for(i=1;i<a.size();i++) 

        {

            for(j=0;j<i;j+=2) 

            {

                a.add(j+1,a.get(j) +a.get(i));

                i++;

            }

        }

        Collections.sort(a);

        return a;

    }

}
