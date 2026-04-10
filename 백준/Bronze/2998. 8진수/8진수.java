import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        
        int first = s.length() % 3;
        
        if (first == 1) sb.append(s.charAt(0) - '0');
        else if (first == 2) {
            sb.append((s.charAt(0) - '0') * 2 + s.charAt(1) - '0');
        }
        
        for (int i = first; i < s.length(); i += 3) {
            sb.append((s.charAt(i) - '0') * 4
                     + (s.charAt(i + 1) - '0') * 2
                     + s.charAt(i + 2) - '0');
        }
        
        System.out.print(sb);
        br.close();
    }
}