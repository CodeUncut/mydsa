class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        // code here
        if(node==null)return 0;
        else{
            int l = height(node.left);
            int r = height(node.right);
            
            if(l>r)return (l +1);
            else return (r+1);
        }
    }
}
