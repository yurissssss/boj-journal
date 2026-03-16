import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            int count = 0;
            boolean isVPS = true;
            
            for (char c : st.toCharArray()) {
                if (c == '(') count++;
                else count--;
                
                if (count < 0) isVPS = false;
            }
            
            if (count != 0) isVPS = false;
            
            sb.append(isVPS ? "YES" : "NO").append('\n');
        }        
        
        System.out.println(sb);
        
        br.close();
    }
}