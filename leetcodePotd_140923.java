class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList();
        Map<String, PriorityQueue<String>> adjList = new HashMap();
        for(List<String> ticket: tickets){
            String from  = ticket.get(0), to = ticket.get(1);
            if (!adjList.containsKey(from))
                adjList.put(from, new PriorityQueue<String>());
            adjList.get(from).offer(to);
        }
        dfs(adjList, result, "JFK");
        return result;
    }
    private void dfs(Map<String, PriorityQueue<String>> adjList,LinkedList<String> result, String from){
        PriorityQueue<String> arrivals= adjList.get(from);
        while(arrivals!=null && !arrivals.isEmpty()){
            String to = adjList.get(from).poll();
            dfs(adjList, result, to);
        }
        result.addFirst(from);
    }
}
