import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] edgeCount = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        // i : [1, N]로 하면 idx는 0 ~ N-1로 들어감
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            edgeCount[b]++;
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            if (edgeCount[i] == 0) dq.offer(i);
        }
        
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            sb.append(cur).append(' ');
            
            for (int i : graph.get(cur)) {
                edgeCount[i]--;
                
                if (edgeCount[i] == 0) {
                    dq.offer(i);
                }
            }
        }
        
        
        System.out.print(sb);
        br.close();
    }
}