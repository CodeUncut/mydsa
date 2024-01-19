class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.y==b.y?a.x-b.x:b.y-a.y);
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<N;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
         pq.add(new Pair(arr[i],hm.get(arr[i])));
         //System.out.println(pq.peek().x+" "+pq.peek().y);
         int k=K;
         PriorityQueue<Pair> temp=new PriorityQueue<>((a,b)->a.y==b.y?a.x-b.x:b.y-a.y);
         ArrayList<Integer> aa=new ArrayList<>();
         Set<Integer> set=new HashSet<>();
         while(!pq.isEmpty() && k>0){
             if(!set.contains(pq.peek().x)){
                 aa.add(pq.peek().x);
                 set.add(pq.peek().x);
                 k--;
             }
             temp.add(pq.poll());
         }
         pq=temp;
         ans.add(aa);
        }
        return ans;
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
