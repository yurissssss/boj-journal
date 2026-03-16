import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        String answer = "mixed";
        
        if (n == 1) {
            answer = "ascending";
            
            for (int i = 2; i <= 8;i++) {
                n = Integer.parseInt(st.nextToken());
                
                if (n != i) {
                    answer = "mixed";
                    break;
                }
            }
        } else if (n == 8) {
            answer = "descending";
            
            for (int i = 7; i > 1; i--) {
                n = Integer.parseInt(st.nextToken());
                
                if (n != i) {
                    answer = "mixed";
                    break;
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}