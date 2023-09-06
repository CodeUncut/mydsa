class Solution 
{
    public:
    //Function to find a Mother Vertex in the Graph.
	void DFS(int u, vector<int> adj[], vector<bool>& visited) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                DFS(v, adj, visited);
            }
        }
    }
    //Function to find a Mother Vertex in the Graph.
    int findMotherVertex(int V, vector<int>adj[])
    {
        // Code here
        vector<bool> visited(V, false);
        int v = -1;  // Last finished vertex in DFS
        
        // Step 1: Find potential mother vertex
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, adj, visited);
                v = i;  // Update the potential mother vertex
            }
        }
        
        // Reset visited array for next DFS
        fill(visited.begin(), visited.end(), false);
        
        // Step 2: Validate if v is a mother vertex
        DFS(v, adj, visited);
        for (bool visit : visited) {
            if (!visit) return -1;
        }
        return v;

}

};
