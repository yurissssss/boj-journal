import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            
            set.add(name);
        }
        
        Set<String> both = new TreeSet<>();
       
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            
            if (set.contains(name)) {
                both.add(name);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(both.size()).append('\n');
        
        for (String s : both) {
            sb.append(s).append('\n');
        }
        
        System.out.print(sb);
        
        br.close();
    }
}