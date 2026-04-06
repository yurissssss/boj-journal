import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int count = 0;
            for (int j = l; j <= r; j++) {
                if (s.charAt(j) == a) count++;
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}