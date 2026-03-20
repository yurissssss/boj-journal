import java.io.*;
import java.util.*;

class Doc {
    int idx;
    int imp;
    
    Doc(int idx, int imp) {
        this.idx = idx;
        this.imp = imp;
    }
}

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
            Deque<Doc> dq = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int imp = Integer.parseInt(st.nextToken());
                dq.offer(new Doc(j, imp));
            }
            
            int count = 0;
            while (true) {
                Doc target = dq.poll();
                boolean isOk = true;
                
                for (Doc d : dq) {
                    if (d.imp > target.imp) {
                        dq.offer(target);
                        isOk = false;
                        break;
                    }
                }
                
                if (isOk) {
                    count++;
                    
                    if (target.idx == idx) {
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