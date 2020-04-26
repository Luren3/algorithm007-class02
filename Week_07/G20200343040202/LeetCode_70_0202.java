class Solution {
        public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int p = 2, q = 1;
        for (int i = 2; i < n; i++) {
            int sum = p + q;
            q = p;
            p = sum;
        }
        return p;
    }
//    public int climbStairs(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
}