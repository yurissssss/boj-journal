import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sb.append(x).append(' ').append(x).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
}