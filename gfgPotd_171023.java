class Solution{
    static void dfs(int adj[][], int N, int node, boolean vis[])
    {
        vis[node] = true;

        for(int i = 0; i < adj[node].length; i++) {
            if(i == node || adj[node][i] == 0)
                continue;

            if(vis[i])
                continue;

            dfs(adj, N, i, vis);
        }
    }
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // code here
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       boolean vis[] = new boolean[N];
       
       for(int i = 0; i < N; i++)
       {
            vis = new boolean[N];
            dfs(graph, N, i, vis);
            ArrayList<Integer> temp = new ArrayList<>();
           
            for(boolean b : vis)
                temp.add( b == true ? 1 : 0 );
            ans.add(temp);
       }
        return ans;
    }
}
