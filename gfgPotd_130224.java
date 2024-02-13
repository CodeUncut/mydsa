class Solution{
    Node cloneGraph(Node node){
        HashSet<Node> visited = new HashSet<>();
        visited.add(node);
        return dFS(node, visited);
    }
    
    private Node dFS(Node root, Set<Node> visitTracker) {
        if(root == null)
            return root;
            
        Node child = new Node(root.val);
        for(Node temp : root.neighbors) {
            if(visitTracker.add(temp))
               child.neighbors.add(dFS(temp, visitTracker));
        }
        
        return child;
    }
}
