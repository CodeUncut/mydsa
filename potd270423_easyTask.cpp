//Easy task

/*
Given a string s whose length is n and array queries of length q where each elements of queries is either of type 1 query or type 2 query which is explained ahead.

There are two types of query.

Query type 1 : ["1",ind,char]  "1" denotes this is type 1 query. In this query you have to change the character at index ind in s to character char.(Data type of ind,char is string in input)

Query Type 2: ["2",left,right,k]  "2" denotes this is type 2 query. In this query you have to return kth lexographically largest character  in the subtring of s (it is the kth largest character in sorted order , not the kth distinct character) starting from index left and ending at index right both left and right are inclusive. (Data type of left,right,k is string in input)

You have to perform each query in the same order as given in  queries and return an array res such that res array contains the answer for each type2 query in same order as it appeared in queries.

Note : 0 based indexing is used.

Example 1:

Input:
n=4
s="abab"
q=2
queries={{"1","2","d"},{"2","1","3","1"}}
Output: 
{"d"}
Explanation:
First query is of type 1 so after changing character at index 2 
to d  s becomes abdb . Now Second query is of type 2 in which 
the 1st(k=1) lexographically largest character is "d" in substring "bdb"(s[1:3]). So we 
returned a array with result of type 2 query {"d"}.
Example 2:

Input:
n=3
s="aaa"
q=3
queries={{"1","1","e"},{"1","2","c"},{"2","1","2","2"}}
Output:
{"c"}
Explanation:
After applying first two queries s becomes aec. Now for 
the last query which is a type 2 second largest character 
in subtring s starting from index 1 to ending at index 2 is "c".
*/

// Answer in c++:

vector<vector<int>> segment;
class Solution{
public:
    void bnado(int index,int left,int right,string s){
        if(left==right){
            segment[index][s[right]-'a']=1;
            return;
        }
        int mid = (left+right)/2;
        bnado(2*index+1,left,mid,s);
        bnado(2*index+2,mid+1,right,s);
        for(int i=0;i<26;i++){
            segment[index][i]=segment[2*index+1][i]+segment[2*index+2][i];
        }
    }
    void update(int index,int left,int right,int Uindex,char c,string s){
        if(Uindex<left or Uindex>right)return;
        segment[index][s[Uindex]-'a']--;
        segment[index][c-'a']++;
        if(left==right)return;
        int mid = (left+right)/2;
        update(2*index+1,left,mid,Uindex,c,s);
        update(2*index+2,mid+1,right,Uindex,c,s);
    }
    void nikaldo(int index,int left,int right,int s,int e,int temp[]){
        if(left>e or right<s)return;
        if(left>=s and right<=e){
            for(int i=0;i<26;i++){
                temp[i]+=segment[index][i];
            }
            return;
        }
        int mid = (left+right)/2;
        nikaldo(2*index+1,left,mid,s,e,temp);
        nikaldo(2*index+2,mid+1,right,s,e,temp);
    }
    vector<char> easyTask(int n,string s,int q,vector<vector<string>> &queries){
        // Code here
        vector<char> ans;
        segment = vector<vector<int>> (4*n,vector<int>(26,0));
        bnado(0,0,n-1,s);
        for(int i=0;i<q;i++){
            if(queries[i][0]=="1"){
                int Uindex = stoi(queries[i][1]);
                char c = queries[i][2][0];
                update(0,0,n-1,Uindex,c,s);
                s[Uindex]=c;
            }
            else{
                int s = stoi(queries[i][1]);
                int e = stoi(queries[i][2]);
                int k = stoi(queries[i][3]);
                int temp[26]={0};
                nikaldo(0,0,n-1,s,e,temp);
                int i;
                for(i=25;i>=0;i--){
                    k-=temp[i];
                    if(k<=0)break;
                }
                ans.push_back('a'+i);
            }
        }
        return ans;
    }
};