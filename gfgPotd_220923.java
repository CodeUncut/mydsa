class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code hereint
        ArrayList<Integer>al= new ArrayList<>();
        int s = x;
        int e = x;
        
        
        for(int i=0;i<n;i++)
       {
            if(arr[i]==s){
            al.add(i);break;
            }
            
        }
        
           for(int i=n-1;i>=0;i--)
        {
            if(arr[i]==s){
            al.add(i);break;
            }
        }
        if(al.isEmpty())
        {
            al.add(-1);
            al.add(-1);
        }
        
        return al;
    }
}
