import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
            }
            
            // 주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
            // -> 가장 적은 비행기: n - 1개
            sb.append(n - 1).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}