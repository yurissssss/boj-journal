import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            
            if (st.equals("ENTER")) {
                set.clear();
            } else {
                if (!set.contains(st)) {
                    set.add(st);
                    count++;
                }
            }
        }
        
        System.out.print(count);
        
        br.close();
    }
}