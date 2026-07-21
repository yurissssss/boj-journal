class Solution {
    public int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    private void dfs(int[] arr, int target, int depth, int sum) {
        if (depth == arr.length) {
            if (sum == target) count++;
            return;
        }
        
        dfs(arr, target, depth + 1, sum - arr[depth]);
        dfs(arr, target, depth + 1, sum + arr[depth]);
    }
}