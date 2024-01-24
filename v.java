class Solution {
    public boolean isTree(int v, int e, ArrayList<ArrayList<Integer>> edges) 
    {
        if(v==1 && e==0){//if there is only one vertix and no edge return true .
            return true;
        }
        //create Map
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<v;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            map.get(edges.get(i).get(1)).add(edges.get(i).get(0));//undirected
        }
        
        boolean visited[] = new boolean[v];
        //check Cycle
        boolean cycle = false;
        for(int i=0;i<v;i++){
            if(!visited[i] && isCycle(map,visited,v,i)){
                cycle = true;
                break;
            }
        }
        if(cycle==true){//if there is cycle then graph is not a Tree
            return false;
        }
        //check for connected graph or not;
        boolean notConnected = false;
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                notConnected = true;
                break;
            }
        }
        if(notConnected==true){//if graph is not connected then it's not a tree.
            return false;
        }
        return true;
        
    }
    
    public static boolean isCycle(HashMap<Integer,ArrayList<Integer>> map,boolean visited[],
                int v,int curr){
        
        int parent[] = new int[v];
        Queue<Integer> q = new LinkedList<>();
        
        Arrays.fill(parent,-1);
        q.add(curr);
        visited[curr] = true;
        
        if(map.get(curr).isEmpty()){
            //0 -> {} . take this situation when 0 is the starting node and there is 
           //           no edege from 0. it's refer graph is not connected. 
           // so just return from here .
            return true;
        }
        while(!q.isEmpty()){
            int u = q.poll();
            for(Integer it : map.get(u)){
                if(!visited[it]){
                    q.add(it);
                    visited[it] = true;
                    parent[it] = u;
                }else if(parent[u]!=it){
                    return true;
                }
            }
        }
        return false;
        
    }
    
}
