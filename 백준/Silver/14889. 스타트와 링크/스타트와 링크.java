import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] abil;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        abil = new int[n][n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                abil[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        
        System.out.print(min);
        
        br.close();
    }
    
    private static void dfs(int depth, int idx) {
        if (depth == n / 2) {
            calc();
            return;
        }
        
        for (int i = idx; i < n; i++) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
    
    private static void calc() {
        int start = 0;
        int link = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) start += abil[i][j];
                if (!visited[i] && !visited[j]) link += abil[i][j];
            }
        }
        
        min = Math.min(min, Math.abs(start - link));
        
        return;
    }
}