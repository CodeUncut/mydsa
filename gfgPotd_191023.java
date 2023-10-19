class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {


        boolean[] vis= new boolean[V];
        
        Queue<Integer> qq= new LinkedList<>();
        qq.add(0);
        int level=0;
        
        while(!qq.isEmpty()){
            int s=qq.size();
            
            while(s!=0){
                
                int x=qq.poll();
                
                if(x==X) return level;
                
                vis[x]=true;
                
                for(int k: adj.get(x)){
                    if(vis[k]==false) qq.add(k);
                }
                s--;
            }
            level++;
            
        }
        return -1;
    }
}
