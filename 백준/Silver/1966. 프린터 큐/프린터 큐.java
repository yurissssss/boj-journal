import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            int m = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> map = new TreeMap<>();
            Deque<Integer> dq = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int imp = Integer.parseInt(st.nextToken());
                map.put(j, imp);
                dq.offer(j);
            }
            
            int count = 0;
            while (true) {
                int target = dq.poll();
                boolean isOk = true;
                
                for (int k = 9; k > map.get(target); k--) {
                    if (map.containsValue(k)) {
                        dq.offer(target);
                        isOk = false;
                        break;
                    }
                }
                
                if (isOk) {
                    count++;
                    map.remove(target);
                    
                    if (target == idx) {
                        sb.append(count).append('\n');
                        break;
                    }
                }
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}