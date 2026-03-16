import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        
        for (int i = 0; i < n; i++) {
            answer *= 2;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}