class Solution
{
    Node BST(ArrayList<Node> list,int start,int end){
        if(start>end)
        return null;
        
        int mid = (start+end)/2;
        Node curnode = list.get(mid);
        
        curnode.left = BST(list,start,mid-1);
        curnode.right = BST(list,mid+1,end);
        
        return curnode;
    }
    Node binaryTreeToBST(Node root){
        ArrayList<Node> list = new ArrayList<>();
        inorder(root,list);
        
        Collections.sort(list,new Comparator<Node>(){
            @Override
            public int compare(Node node1,Node node2){
                return Integer.compare(node1.data,node2.data);
            }
        });
        return BST(list,0,list.size()-1);
    }
    void inorder(Node curnode,ArrayList<Node> list){
        if(curnode == null){
            return;
        }
        list.add(curnode);
        inorder(curnode.left,list);
        inorder(curnode.right,list);
        
    }
}
