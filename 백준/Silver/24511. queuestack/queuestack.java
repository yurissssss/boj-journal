import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] type = new int[n];
        int[] value = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        
        /*
        stack: 후입선출 -> 들어온 값이 그대로 나감
        queue: 선입선출 -> 원래 있던 값이 나감
        -> queue만 보면 됨!
        --> queue인 경우만 뒤에서부터 담기! (마지막 값 = x)
        */
        
        for (int i = n - 1; i >= 0; i--) {
            if (type[i] == 0) dq.offer(value[i]);
        }
        
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            dq.offer(x);
            
            // 이미 queue인 경우만 담아놔서 
            // 앞에서 꺼내면 정답이 나오는 구조 완성!
            sb.append(dq.poll()).append(" ");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}