//Function to check whether a Binary Tree is BST or not.
public static void findPreSuc(Node root, int key)
{
    // code here.
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
    Node temp = root;
    while(temp!=null){
        if(temp.data>=key) temp=temp.left;
        else{
            pre =temp;
            temp=temp.right;
        }
    }
    temp =root;
    while(temp!=null)
    {
        if(temp.data<=key) temp=temp.right;
        else{
            suc=temp;
            temp=temp.left;
            }
        }
    }
}
