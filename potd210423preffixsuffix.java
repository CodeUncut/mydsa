public int prefixSuffixString(String s1[],String s2[])
    {
        Map<String,Boolean> mm = new HashMap<>();
        for(String x:s1)
        {
            StringBuilder temp = new StringBuilder();
            String temp ="", x="";
            for(int i=0; i<x.length(); i++)
            {
                temp.append(x.charAt(i));
                mm.put(temp.toString(), true);
            }
            temp.setLength(0);
            for(int i= x.length()-1; i>=0;i--)
            {
                temp.insert(0, x.charAt(i));
                mm.put(temp.toString(), true);
            }
        }
        int ans=0;
        for(String x:s2)
        {
            if(mm.get(x)!=null) ans++;
        }
        return ans;    
        
    }