import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static Deque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0);
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int n) {
        if (n == M) {
            for (int i : dq) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == prev) continue;
            
            if (!visited[i]) {
                visited[i] = true;
                dq.offer(arr[i]);
                prev = arr[i];
                
                dfs(n + 1);
                
                dq.pollLast();
                visited[i] = false;
            }
        }
    }
}