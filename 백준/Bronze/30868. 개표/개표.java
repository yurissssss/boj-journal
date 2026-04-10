import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int vote = Integer.parseInt(br.readLine());
            
            while (vote != 0) {
                if (vote >= 5) {
                    sb.append("++++ ");
                    vote -= 5;
                } else {
                    sb.append('|');
                    vote--;
                }
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}