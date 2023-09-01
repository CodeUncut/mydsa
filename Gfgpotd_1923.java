

//User function Template for Java

/* Node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree
{
    public static void printCorner(Node node) {
        LinkedList<Node> p = new LinkedList<>();
        LinkedList<Node> c = new LinkedList<>();
        p.addLast(node);
        System.out.print(node.data + " ");
        
        while(!p.isEmpty()) {
            c.clear();
            
            while(!p.isEmpty()) {
                Node n  = p.poll();
                
                if(n.left != null) c.addLast(n.left);
                if(n.right != null) c.addLast(n.right);
            }
            if(c.size() == 1) System.out.print(c.get(0).data + " ");
            else if (c.size() > 1)System.out.print(c.get(0).data + " " + c.get(c.size()-1).data + " ");

            p.addAll(c);
        }
        
    }
    
}
