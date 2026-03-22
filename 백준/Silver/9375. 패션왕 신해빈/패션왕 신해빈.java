import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String sort = st.nextToken();
                
                map.put(sort, map.getOrDefault(sort, 0) + 1);
            }
            
            int count = 1;
            for (int k : map.values()) {
                count *= k + 1;  // 같은 분류의 아이템들 중 하나를 입거나 안 입거나
            }
            
            // 모두 다 안 입는 경우 제외
            sb.append(count - 1).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}