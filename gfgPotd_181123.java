public static Node reverseDLL(Node  head)
{
    //Your code here
    ArrayList<Integer>list=new ArrayList<>();
    Node curr=head;
    while(curr!=null){
        list.add(curr.data);
        curr=curr.next;
    }
    Node start=null;
    Node ptr=null;
   // curr=null;
    int j=list.size()-1;
    while(j>=0){
        Node n=new Node(list.get(j));
        if(start==null){
            start=n;
            start.prev=null;
            start.next=null;
            ptr=start;
        }
        else{
            ptr.next=n;
            n.prev=ptr;
            n.next=null;
            ptr=n;
        }
        j--;
    }
    return start;
    }
