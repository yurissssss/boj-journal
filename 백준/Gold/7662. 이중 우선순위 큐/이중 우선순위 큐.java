import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       
        int T = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < T; i++) {   
            int k = Integer.parseInt(br.readLine());  
            
            TreeMap<Integer, Integer> map = new TreeMap<>();
            
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
            
                if (order.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else {
                    if (map.isEmpty()) continue;
                    else if (n == -1) {
                        int x = map.firstKey();
                        map.put(x, map.get(x) - 1);
                        if (map.get(x) == 0) map.remove(x);
                    } else {
                        int x = map.lastKey();
                        map.put(x, map.get(x) - 1);
                        if (map.get(x) == 0) map.remove(x);
                    }
                }
            }
            if (map.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}