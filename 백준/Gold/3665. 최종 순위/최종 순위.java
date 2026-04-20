import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            int[] indegree = new int[n + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < n + 1; j++) {
                graph.add(new ArrayList<Integer>());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                
                int idx = j - 1;
                while (idx > 0) {
                    graph.get(arr[idx--]).add(arr[j]);
                    indegree[arr[j]]++;
                }
            }
            
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
             
                if (graph.get(a).contains(b)) {
                    graph.get(a).remove(Integer.valueOf(b));
                    indegree[b]--;
                    graph.get(b).add(a);
                    indegree[a]++;
                } else {
                    graph.get(b).remove(Integer.valueOf(a));
                    indegree[a]--;
                    graph.get(a).add(b);
                    indegree[b]++;
                }
            }
            
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 1; j < n + 1; j++) {
                if (indegree[j] == 0) dq.offer(j);
            }
            
            boolean isOk = true;
            int idx = 1;
            while (idx <= n) {
                if (dq.size() > 1) {
                    isOk = false;
                    sb.append("?").append('\n');
                    break;
                } else if(dq.size() == 0) {
                    isOk = false;
                    sb.append("IMPOSSIBLE").append('\n');
                    break;
                }
                
                int cur = dq.poll();
                arr[idx++] = cur;
                    
                for (int x : graph.get(cur)) {
                    if (--indegree[x] == 0) {
                        dq.offer(x);
                    }
                } 
            }
            
            if (isOk) {
                for (int j = 1; j < n + 1; j++) {
                    sb.append(arr[j]).append(' ');
                }
                sb.append('\n');
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}