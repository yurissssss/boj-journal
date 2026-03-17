import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int idx = 0;
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String a = st.nextToken();
            String b = st.nextToken();
            
            if (set.contains(a) && !set.contains(b)) {
                set.add(b);
                count++;
            } else if ((set.contains(b) && !set.contains(a))) {
                set.add(a);
                count++;
            }
        }
        
        System.out.print(count);
        
        br.close();
    }
}