class Solution {
    public static void rearrange(Node odd) {
        // If the list has less than 3 nodes, no rearrangement needed
        if (odd == null || odd.next == null || odd.next.next == null)
            return;
        
        Node even = odd.next;
        // Rearrange the list by swapping nodes
        odd.next = odd.next.next;
        odd = odd.next;
        even.next = null;
        
        while (odd != null && odd.next != null) {
            // Swap nodes to rearrange the list
            Node temp = odd.next.next;
            odd.next.next = even;
            even = odd.next;
            odd.next = temp;
            
            // Move odd pointer to the next node
            if (temp != null)
                odd = temp;
        }
        
        // Connect the last node of odd list with the even list
        odd.next = even;
    }
}
