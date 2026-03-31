import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String p = br.readLine();  // 수행할 함수
            int n = Integer.parseInt(br.readLine());  // 배열 크기
            String s = br.readLine();  // 배열
            
            Deque<Integer> q = new ArrayDeque<>();
            
            String num = "";
            for (int j = 1; j < s.length() - 1; j++) {
                char c = s.charAt(j);
                
                if (c == ',') {
                    q.offer(Integer.parseInt(num));
                    num = "";
                } else {
                    num += c;
                }
            }
            
            if (!num.equals("")) {
                q.offer(Integer.parseInt(num));
            }
            
            boolean isReversed = false;
            boolean isError = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (q.isEmpty()) {
                        isError = true;
                        sb.append("error").append('\n');
                        break;
                    } else if (isReversed) {
                        q.pollLast();
                    } else {
                        q.pollFirst();
                    }
                }
            }
            
            if (isError) continue;
            
            sb.append('[');
            while (!q.isEmpty()) {
                if (isReversed) sb.append(q.pollLast());
                else sb.append(q.pollFirst());
                
                if(!q.isEmpty()) {
                    sb.append(',');
                }
            }
            if(q.isEmpty()) {
                sb.append(']').append('\n');
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}