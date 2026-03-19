import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] nums;
    static int[] codes = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            codes[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, nums[0]);
        
        System.out.println(max);
        System.out.println(min);
        
        br.close();
    }
    
    private static void dfs(int depth, int value) {
        if (depth == n) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        
        if (codes[0] > 0) {
            codes[0]--;
            dfs(depth + 1, value + nums[depth]);
            codes[0]++;
        }
        
        if (codes[1] > 0) {
            codes[1]--;
            dfs(depth + 1, value - nums[depth]);
            codes[1]++;
        }
        
        if (codes[2] > 0) {
            codes[2]--;
            dfs(depth + 1, value * nums[depth]);
            codes[2]++;
        }
        
        if (codes[3] > 0) {
            codes[3]--;
            dfs(depth + 1, value / nums[depth]);
            codes[3]++;
        }
    }
}