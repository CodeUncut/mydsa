class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        ArrayList<Integer> list = new ArrayList<>();
        addData(root,0);
        for(int i = 0;i< map.size();i++) {
            if(i%2!=0) {
                for(int j = map.get(i).size()-1;j>=0;j--) {
                   list.add(map.get(i).get(j));
                }
            }
            else {
                for(int j = 0;j<map.get(i).size();j++) {
                    list.add(map.get(i).get(j));
                }
            }
        }
        
        return list;
        
    }
    public void addData(Node root,int lvl) {
        if(root == null) {
            return;
        }
        if(!map.containsKey(lvl)) {
            map.put(lvl,new ArrayList<>());
        }
        map.get(lvl).add(root.data);
        addData(root.left,lvl+1);
        addData(root.right,lvl+1);
    }
}
