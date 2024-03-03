class Solution {
    String printLargest(int n, String[] arr) {
        // code here
            Comparator<String> customComparator = (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        };

        // Sort the array using the custom comparator
        Arrays.sort(arr, customComparator);

        // Concatenate the sorted array to get the largest possible number
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }

        // Handle leading zeros
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
