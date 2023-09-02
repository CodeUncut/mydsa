class Pair{
    Node node;
    int count;
    Pair(Node node,int count){
        this.node=node;
        this.count=count;
    }
} 
class Solution{
    public int getCount(Node node, int bud)
    {
        int count=0,sum=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,1));
        while(!q.isEmpty()){
             Node currNode=q.peek().node;
             int lev=q.peek().count;
             q.remove();
             if(currNode.left==null & currNode.right==null){
                   count++;
                   sum+=lev;
                   if(sum>bud)return count-1;
                   if(sum==bud)return count;
               }
             if(currNode.left!=null )q.add(new Pair(currNode.left,lev+1));
             if(currNode.right!=null)q.add(new Pair(currNode.right,lev+1));
        }
       
       return count;
    }
}
