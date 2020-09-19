/**
Recursion with Memoization.
*/

class Solution {
    public int climbStairs(int n) {
        if (n == 0)
            return 0;
        
        if (n == 1)
            return 1;
        
        if (n == 2)
            return 2;
        
         //create array to keep track of # of steps for sub problems
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        
        return helper(n, arr);
        
    }
    public int helper(int n, int[] arr) {
        if (n <= 0)
            return 0;
        if (arr[n] != 0)
            return arr[n];
        arr[n] = helper(n-1, arr) + helper(n-2, arr);
        return arr[n];
    }
}
