class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root){
    
        int x=balanced(root);
        return (x!=-1);
        
    }
    
    int balanced(Node root){
        
        if(root==null) return 0;
        
        int l=balanced( root.left);
        int r=balanced( root.right);
        
        if(l==-1 || r==-1 || Math.abs(l-r)>1) return -1;
        
        return 1+Math.max(l,r);
    }
}
