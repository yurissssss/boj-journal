import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        
        int answer = 0;
        for (int i = 0; i < M - 2 * N; i++) {
            char c = S.charAt(i);
            boolean isTrue = true;
            
            if (c == 'I') {
                for (int j = 1; j <= N; j++) {
                    int odd = 2 * j - 1;
                    int even = 2 * j;
                    if (S.charAt(i + odd) != 'O' || S.charAt(i + even) != 'I') {
                        isTrue = false;
                        break;
                    }
                }
            } else isTrue = false;
            
            if (isTrue) answer++;
        }
        
        System.out.print(answer);
        br.close();
    }
}