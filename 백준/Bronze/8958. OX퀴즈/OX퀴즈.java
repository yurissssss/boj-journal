import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            int sum = 0;
            int count = 0;
            
            for (char c : st.toCharArray()) {
                switch (c) {
                    case 'O':
                        count++;
                        sum += count;
                        break;
                        
                    default:
                        count = 0;
                        break;
                }
            }
            
            sb.append(sum).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}