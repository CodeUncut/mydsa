class Tree
{
    public static float findMedian(Node root)
    {
        int cnt =  morris(root);
         Node curr = root, preptr = null, prev = null;
        int currcnt=0;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                // if(k==1) return curr;
                // k--;
                //odd
                // Odd case
                  currcnt++;
                if (cnt % 2 != 0 && currcnt == (cnt + 1) / 2)
                    return curr.data;
                    
                    //even case
                 else if (cnt % 2 == 0 && currcnt == (cnt / 2) + 1)
                    return (float) (preptr.data + curr.data) / 2;
                    
                    // Update prev for even no. of nodes
                preptr = curr;
                
                curr=curr.right;
            }
            
           
            else
            {
                //move as right as poss
                 prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                prev= prev.right;
                
                if(prev.right==null)
                {
                    prev.right=curr; // make thread
                    curr=curr.left; //do the same for remaining lst
                    
                }
                else //prev.right!=null // thread alreadt there
                {
                    prev.right=null;
                    //access the node since inorder
                    // if(k==1) return curr;
                    //  k--; 
                    // cnt++;
                    currcnt++;
                if (cnt % 2 != 0 && currcnt == (cnt + 1) / 2)
                    return curr.data;
                    
                    //even case
                 else if (cnt % 2 == 0 && currcnt == (cnt / 2) + 1)
                    return (float) (preptr.data + curr.data) / 2;
                    
                      preptr = curr;
                      
                    curr= curr.right;
                }
            }
        }
          return -1;
    }
     static int morris(Node curr)
    {
        int cnt=0;
         while(curr!=null)
        {
            if(curr.left==null)
            {
                // if(k==1) return curr;
                // k--;
                cnt++;
                curr=curr.right;
            }
            
           
            else
            {
                //move as right as poss
                 Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                prev= prev.right;
                
                if(prev.right==null)
                {
                    prev.right=curr; // make thread
                    curr=curr.left; //do the same for remaining lst
                    
                }
                else //prev.right!=null // thread alreadt there
                {
                    prev.right=null;
                    //access the node since inorder
                    // if(k==1) return curr;
                    //  k--; 
                    cnt++;
                    curr= curr.right;
                }
            }
        }
        return cnt;
    }
}
