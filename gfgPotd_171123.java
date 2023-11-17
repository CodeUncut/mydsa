Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    Node head=null,prev=null;
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            if(head==null){
                head=root;
            }
            if(prev!=null){
                prev.right=root;
            }
            root.left=prev;
            prev=root;
            inorder(root.right);
        }
    }
    Node bTreeToClist(Node root)
    {
        //your code here
        if(root==null){
            return null;
        }
        inorder(root);
        prev.right=head;
        head.left=prev;
        return head;
    }   
}
