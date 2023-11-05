class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < nums.length; i++) {
            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            if (mp.containsKey(nums[i])) {
                mp.put(nums[i], mp.get(nums[i]) + 1);
            } else
                mp.put(nums[i], 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
            new ArrayList<Map.Entry<Integer, Integer>>(mp.entrySet());

        // Sort the list
        Collections.sort(
            list,
            new Comparator<Map.Entry<Integer, 
                                     Integer> >() 
          {
                  public int compare(
                    Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2)
                {
                    if (o1.getValue() == o2.getValue()){
                        if(o2.getKey() > o1.getKey()) return 1;
                        else return -1;
    }
    else {
        if (o2.getValue() > o1.getValue())
            return 1;
        else
            return -1;
    }
}
});

int[] ans = new int[k];
for (int i = 0; i < k; i++) {
    ans[i] = list.get(i).getKey();
}

return ans;
}
}
