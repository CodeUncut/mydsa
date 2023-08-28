class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	// Your code here	
	if(head == null) {
        return null;
    }
    
    Node p = head;
    while(p != null && head.data == p.data) {
        p = p.next;
    }
    
    head.next = removeDuplicates(p);
    
    return head;
    }
}
