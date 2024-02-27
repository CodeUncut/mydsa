class Solution{   
// Function for finding maximum and value pair
    public static int[] game_with_number (int arr[], int n) {
        // Complete the function
        // Recursive
        helper(arr, 0 , n);
        return arr;
    }
    public static void helper(int[] arr , int i , int n ){
        if( i > n-2 ) return;
        arr[i] = arr[i] | arr[i+1];
        helper(arr, i+1 , n);
    } 
}
