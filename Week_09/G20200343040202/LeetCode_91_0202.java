class Solution {
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            char pre = s.charAt(i - 1);
            dp[i + 1] = c == '0' ? 0 : dp[i];
            if (pre == '1' || (pre == '2' && c <= '6')) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }
}