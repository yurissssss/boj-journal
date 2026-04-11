import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] response = new String[N];
        
        for (int i = 0; i < N; i++) {
            response[i] = br.readLine();
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            String answer = br.readLine();
            
            if (response[i].equals(answer)) count++;
        }
        
        System.out.print(count);
        br.close();
    }
}