import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(a, s.charAt(b));
            sb.setCharAt(b, s.charAt(a));
            s = sb.toString();
        }
        
        System.out.print(s);
        br.close();
    }
}