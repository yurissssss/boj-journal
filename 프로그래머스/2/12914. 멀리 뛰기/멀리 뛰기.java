class Solution {
    public long solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) dp[2] = 2;
        
        // dp[i - 1]: 마지막 점프 1칸
        // dp[i - 2]: 마지막 점프 2칸
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        return dp[n];
    }
}