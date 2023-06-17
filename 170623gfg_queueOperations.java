//User function Template for Java

// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks{
    
    // Function to insert element into the queue
    static HashMap<Integer, Integer> map;
    static boolean a= false;
    static void insert(Queue<Integer> q, int k){
        
        if(a == false){
            map =new HashMap<>();
            a= true;
        }
        q.add(k);
        map.putIfAbsent(k,0);
        map.put(k, map.get(k)+1);
        // Your code here
        
    }
    
    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        
        // Your code here
        a= false;
        if(map.get(k)==null)return 0;
        return map.get(k);
    }
    
}
