/* BST Node
struct Node
{
	int key;
	struct Node *left;
	struct Node *right;
	
	Node(int x){
	    key = x;
	    left = NULL;
	    right = NULL;
	}
};
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class Solution
{
    public:
    void findPreSuc(Node* root, Node*& pre, Node*& suc, int key)
    {
        // Your code goes here
        Node *temp = root;
        while(temp){
            if(temp->key>=key)temp= temp->left;
            else{
                pre=temp;
                temp=temp->right;
            }
        }
        temp=root;
        while(temp){
            if(temp->key<=key)temp =temp->right;
            else{
                suc = temp;
                temp= temp->left;
            }
        }
    }
};
