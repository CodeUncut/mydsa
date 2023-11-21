class Solution
{
    //Function to check if two trees are identical.
 ArrayList<Integer> hasA = new ArrayList<>();
    ArrayList<Integer> hasB = new ArrayList<>();
    
    void recur(Node root, ArrayList<Integer> has){
        if(root==null){
            return;
        }
        
        
            has.add(root.data);
            recur(root.left,has);
            recur(root.right,has);
        
        
    }
    boolean isIdentical(Node root1, Node root2)
    {
        // Code Here
        
      recur(root1,hasA);
      recur(root2,hasB);
      
      return hasA.equals(hasB);
        
        
    }
	
}
