import java.io.*;

public class Main {
    static int MOD = 20000303;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer = (answer * 10 + s.charAt(i) - '0') % MOD;
        }
        
        System.out.print(answer);
        br.close();
    }
}