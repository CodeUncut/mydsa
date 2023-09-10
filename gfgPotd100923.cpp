class Solution
{
    public:
        Node* insert(Node* node, int data) {
            
            if(node==NULL)
            {
                return new Node(data);
            }
            
            if(node->data==data) return node;
            
            if(node->data>data)
            {
                node->left=insert(node->left,data);
            }
            else{
                node->right=insert(node->right,data);
            }
            
            return node;
    }

};
