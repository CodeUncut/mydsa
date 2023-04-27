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

// Answer in Java

   static int segment[][];
    static void bnado(int left,int right,int index,char s[]){
        if(left==right){
            segment[index][s[right]-'a']=1;
            return;
        }
        int mid = (left+right)/2;
        bnado(left,mid,2*index+1,s);
        bnado(mid+1,right,2*index+2,s);
        for(int i=0;i<26;i++){
            segment[index][i]=segment[2*index+1][i]+segment[2*index+2][i];
        }
    }
    static void update(int left,int right,int index,int Uindex,char s[],char c){
        if(Uindex<left || Uindex>right)return;
        segment[index][s[Uindex]-'a']--;
        segment[index][c-'a']++;
        if(left==right)return;
        int mid = (left+right)/2;
        update(left,mid,2*index+1,Uindex,s,c);
        update(mid+1,right,2*index+2,Uindex,s,c);
    }
    static void nikaldo(int left,int right,int index,int s,int e,int temp[]){
        if(s>right || e<left)return;
        if(left>=s && right<=e){
            for(int i=0;i<26;i++){
                temp[i]+=segment[index][i];
            }
            return;
        }
        int mid = (left+right)/2;
        nikaldo(left,mid,2*index+1,s,e,temp);
        nikaldo(mid+1,right,2*index+2,s,e,temp);
    }
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        ArrayList<Character> ans = new ArrayList<>();
        segment = new int[4*n][26];
        char cc[]=s.toCharArray();
        bnado(0,n-1,0,cc);
        for(int i=0;i<q;i++){
            if(queries[i].type=="1"){
                int Uindex=Integer.parseInt(queries[i].a);
                char c=queries[i].b.charAt(0);
                update(0,n-1,0,Uindex,cc,c);
                cc[Uindex]=c;
            }
            else{
                int temp[] = new int[26];
                int l=Integer.parseInt(queries[i].a);
                int r=Integer.parseInt(queries[i].b);
                int k=Integer.parseInt(queries[i].c);
                nikaldo(0,n-1,0,l,r,temp);
                int j=0;
                for(j=25;j>=0;j--){
                    k-=temp[j];
                    if(k<=0)break;
                }
                ans.add((char)('a'+j));
            }
        }
        return ans;
    }