import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        while (N > 0) {
            answer = answer * 2 + (N % 2);
            N /= 2;
        }
        
        System.out.print(answer);
        br.close();
    }
}