import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = n; i >= 1; i--) {
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(max, x - i);
        }
        
        System.out.print(max);
        br.close();
    }
}