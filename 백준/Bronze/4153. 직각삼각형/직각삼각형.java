import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == 0) break;
            
            int max = Math.max(Math.max(a, b), c);
            
            if (max == a) {
                    if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
                        sb.append("right").append("\n");
                    } else sb.append("wrong").append("\n");
            } else if (max == b) {
                    if (Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) {
                        sb.append("right").append("\n");
                    } else sb.append("wrong").append("\n");
            } else {
                if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
                    sb.append("right").append("\n");
                } else sb.append("wrong").append("\n");
            }
        }
        System.out.print(sb);
        
        br.close();
    }
}