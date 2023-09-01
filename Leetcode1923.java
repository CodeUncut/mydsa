class Solution {
  public int[] countBits(int n) {
        int[] counts=new int[n+1];
        for(int i=1;i<=n;++i){
            counts[i]=i%2+counts[i/2];
        }
        return counts;
}
}
