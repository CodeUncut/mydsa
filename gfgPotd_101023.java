class Solution
{
    public static Node SearchTarget(Node root,int val){
        if(root==null)return null;
        if(root.data==val)return root;
        Node left=SearchTarget(root.left,val);
        Node right=SearchTarget(root.right,val);
        if(left==null)return right;
        return left;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        HashMap<Node,Node>mp=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            Node temp=q.remove();
            if(temp.left!=null){
                mp.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                mp.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<Node,Integer>isVisit=new HashMap<>();
        Queue<Node>q1=new LinkedList<>();
        Node node=SearchTarget(root,target);
        q1.add(node);
        isVisit.put(node,0);
        while(q1.size()!=0){
            Node temp=q1.poll();
            
            if(temp.left!=null && !isVisit.containsKey(temp.left)){
                Node left=temp.left;
                q1.add(left);
                isVisit.put(left,isVisit.get(temp)+1);
                if(isVisit.get(left)==k){
                    ans.add(left.data);
                }
            }
            
            if(temp.right!=null && !isVisit.containsKey(temp.right)){
                Node right=temp.right;
                q1.add(right);
                isVisit.put(right,isVisit.get(temp)+1);
                if(isVisit.get(right)==k){
                    ans.add(right.data);
                }
            }
            
            if(mp.containsKey(temp) && !isVisit.containsKey(mp.get(temp))){
                Node parent=mp.get(temp);
                q1.add(parent);
                isVisit.put(parent,isVisit.get(temp)+1);
                if(isVisit.get(parent)==k){
                    ans.add(parent.data);
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
};
