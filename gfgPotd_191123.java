class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        if(head1 == null)
            return head2;
            
        if(head2 == null)
            return head1;
            
        Node dummy = new Node(0);
        Node temp = dummy;
        
        while(head1 != null && head2 != null) 
        {
            if(head1.data == head2.data) 
            {
                temp.next = new Node(head1.data);
                head1 = head1.next;
                head2 = head2.next;
                temp = temp.next;
            } 
            else if(head1.data < head2.data)
                head1 = head1.next;
            else
                head2 = head2.next;
        }
        
        return dummy.next;
    }
}
