class Solution
{
    static ArrayList<Integer> ans;
    static HashSet<Integer> set;
    Solution(){
        ans = new ArrayList<>();
        set = new HashSet<>();
    }
    
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        preorder(root1);
        preorder(root2);
        Collections.sort(ans);
        return ans;
    }
    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        if(set.contains(root.data)){
            ans.add(root.data);
        }else{
            set.add(root.data);
        }
        preorder(root.left);
        preorder(root.right);
    }
}
