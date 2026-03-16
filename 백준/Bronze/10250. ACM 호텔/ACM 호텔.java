import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            int floor = 0;
            int room = 0;
            
            if (num % height == 0) {
                floor = height;
                room = num / height;
            } else {
                floor = num % height;
                room = num / height + 1;
            }
            
            sb.append(floor);
            
            if (room < 10) sb.append("0");
            
            sb.append(room).append("\n");
        }
       
        System.out.print(sb);
        
        br.close();
    }
}