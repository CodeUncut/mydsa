class Solution {

    public Node pairwiseSwap(Node start)
    {
       if(start.next == null){
           return start;
       }
        //for first 2 node
        Node p = start;
        Node q = p.next;
        p.next = q.next;
        q.next = p;
        
        start = q;
        p = null;
        q = null;
        
        //for rest of the node.
        p = start;
        if(p.next.next!=null){
            p = p.next.next;
        }else{
            return start;
        }
        if(p.next == null){
            return start;
        }
        Node prev = start.next;
        q = p.next;
        
        while(q!=null){
            p.next = q.next;
            q.next = p;
            prev.next = q;
            prev = p;
            if(p.next == null){
                break;
            }
            p=p.next;
            q = p.next;
        }

        return start;
        
    }
}
