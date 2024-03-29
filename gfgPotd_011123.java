class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int i=0;i<N;i++){
            if(map.get(i+1) != null)
                arr[i] = map.get(i+1);
            else
                arr[i] = 0;
        }
    }
}
