import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] big = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
                
            big[i][0] = Integer.parseInt(st.nextToken());
            big[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n; i++) {
            int rank = 1;
            
            for (int j = 0; j < n; j++) {
                if (i == j) continue;  // 나랑은 비교 ❎
                
                if (big[i][0] < big[j][0] && big[i][1] < big[j][1]) rank++;
            }
            
            sb.append(rank).append(' ');
        }
        
        System.out.print(sb);
        
        br.close();
    }
}