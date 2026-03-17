import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String n = "";
        
        while (!(n = br.readLine()).equals("0")) {
            boolean ok = true;
            
            for (int i = 0; i < n.length() / 2 + 1; i++) {
                if (n.charAt(i) != n.charAt(n.length() - 1 - i)) {
                    ok = false;
                    break;
                }
            }
            
            sb.append(ok ? "yes" : "no").append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}