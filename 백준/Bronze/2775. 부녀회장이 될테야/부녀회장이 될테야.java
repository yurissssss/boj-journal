import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        int res = 0;
        
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine()) + 1;
            int n = Integer.parseInt(br.readLine());
            
            sb.append(setResident(k, n)).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static int setResident(int k, int n) {
        if (k == 1) return n;
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            answer += setResident(k - 1, i);
        }
        
        return answer;
    }
}