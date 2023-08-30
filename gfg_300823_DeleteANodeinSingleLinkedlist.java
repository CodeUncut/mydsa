//DeleteANodeinSingleLinkedlist
class GfG
{
    Node deleteNode(Node head, int x)
    {
    // Your code here
    if(x==1) 
    return head.next;
    int c = 2;
    Node temp = head;
    while(temp != null)
    {
        if(c == x)
        {
            temp.next = temp.next.next;
        }
        c++;
        temp = temp.next;
    }
    return head;
    }
}
