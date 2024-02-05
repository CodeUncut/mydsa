class Sort
  {public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        if(head==null){
           newNode.next=newNode;
           return newNode;
        } 
        Node prev=head;
        Node curr=head.next;
         
        while(curr!=head){
            if(prev.data<=data && data<=curr.data) break;
            prev=curr;
            curr=curr.next;
        }
        
        prev.next=newNode;
        newNode.next=curr;

        return (data<head.data)?newNode:head;
    }}
