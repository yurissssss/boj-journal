import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;
        int i = 1;
        
        for (char c : s.toCharArray()) {
            sum += (c - 'a' + 1) * i;
            i *= 31;
        }
        
        System.out.print(sum);
        
        br.close();
    }
}