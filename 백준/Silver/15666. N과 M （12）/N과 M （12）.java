import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        dfs(0, 0);
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int idx, int n) {
        if (n == M) {
            for (int i : dq) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        int prev = -1;
        for (int i = idx; i < N; i++) {
            // dfs 수행한 뒤 return되어 돌아왔을 때 중복 방지
            // -> 이 때의 prev는 -1(❎), arr[i](🅾️)
            if (arr[i] == prev) continue;
            
            dq.offer(arr[i]);
            prev = arr[i];
            
            dfs(i, n + 1);
            dq.pollLast();
        }
    }
}