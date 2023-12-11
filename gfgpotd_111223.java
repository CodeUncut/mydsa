class Solution{

    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){

        // code here

        long mxsm = 0, tsum = 0;

        int i=0, j=0;

        while(j<N){

            tsum += Arr.get(j);

            j++;

            if(j-i==K){

                mxsm = Math.max(mxsm,tsum);

                tsum -= Arr.get(i);

                i++;

            }

        }

        return mxsm;

    }

}
