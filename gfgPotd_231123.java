class Solution
{
    public  Node insertToAVL(Node node,int data)
    {
        // If node is null, create a new node with given data
        if (node == null)
        return(new Node(data));
        
        // If data is less than current node data, insert it in the left subtree
        if (data < node.data)
            node.left = insertToAVL(node.left, data);
        // If data is greater than current node data, insert it in the right subtree
        else if(data>node.data)
            node.right = insertToAVL(node.right, data);
       // If the data is equal to current node data, return the node as inserting duplicates is not allowed  
       else
           return node;
        
        // Update the height of the current node
        node.height = max(height(node.left), height(node.right)) + 1;
        
        // Get the balance factor of the current node
        int balance = getBalance(node);
        
        // Perform necessary rotations based on the balance factor and position of the data in the tree
        if (balance > 1 && data< node.left.data)
            return rightRotate(node);
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);
        if (balance > 1 && data> node.left.data)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && data< node.right.data)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        // Return the modified tree after insertion
        return node;
    }
    
    // Function to get the height of a node
    public  int height(Node N)
    {
        if (N == null)
            return 0;
        return N.height;
    }
    
    // Function to get the maximum of two numbers
    public  int max(int a, int b)
    {
        return (a > b)? a : b;
    }
    
    // Function to create a new node with given key
    public  Node newNode(int key)
    {
        Node node =new Node(0);
        node.data = key;
        node.left = null;
        node.right = null;
        node.height = 1; 
        return node;
    }
    
    // Function to perform a right rotation at a given node
    public  Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right))+1;
        x.height = max(height(x.left), height(x.right))+1;
        return x;
    }
    
    // Function to perform a left rotation at a given node
    public  Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right))+1;
        return y;
    }
    
    // Function to get the balance factor of a node
    public  int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    
    // Function to check if the tree is AVL balanced
    public  int __getBalance__(Node root)
    {
       int lh;
       int rh;
       if(root == null)
        return 1; 
       lh = height(root.left);
       rh = height(root.right);
       if( Math.abs(lh-rh) <= 1)
           if(__getBalance__(root.left)==1)
            if( __getBalance__(root.right)==1)
                return 1;
       return 0;
    }
}
