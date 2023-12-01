class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return rahee(root,1,Integer.MAX_VALUE);
    }
    public static boolean rahee(Node root, int min,int max)
    {
        if(root == null)
        return false;
        if(min == max)
        return true;
        
        return rahee(root.left,min,root.data - 1) || rahee(root.right,root.data + 1,max);
    }
}
