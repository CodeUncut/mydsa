class Solution {

    static class Pair {
        int first, second;
        Pair(int x, int y) {
            first = x;
            second = y;
        }
    }

    int getMinDiff(int[] arr, int n, int k) {
        ArrayList<Pair> v = new ArrayList<Pair>();

        int[] taken = new int[n];

        // we will store all possible heights in a vector
        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) {
                v.add(new Pair(arr[i] - k, i));
            }
            v.add(new Pair(arr[i] + k, i));
        }

        Collections.sort(v, new Comparator<Pair>() {
            @Override   public int compare(Pair p1, Pair p2) {
                if (p1.first == p2.first) return p1.second - p2.second;
                return p1.first - p2.first;
            }
        });

        int elements_in_range = 0;
        int left = 0;
        int right = 0;

        // By two pointer we will traverse v and whenever we will get a range
        // in which all towers are included, we will update the answer.
        while (elements_in_range < n && right < v.size()) {
            if (taken[v.get(right).second] == 0) {
                elements_in_range++;
            }
            taken[v.get(right).second]++;
            right++;
        }
        int ans = v.get(right - 1).first - v.get(left).first;
        while (right < v.size()) {
            if (taken[v.get(left).second] == 1) {
                elements_in_range--;
            }
            taken[v.get(left).second]--;
            left++;

            while (elements_in_range < n && right < v.size()) {
                if (taken[v.get(right).second] == 0) {
                    elements_in_range++;
                }
                taken[v.get(right).second]++;
                right++;
            }

            if (elements_in_range == n) {
                ans = Math.min(ans, v.get(right - 1).first - v.get(left).first);
            } else
                break;
        }
        return ans;
    }
}
