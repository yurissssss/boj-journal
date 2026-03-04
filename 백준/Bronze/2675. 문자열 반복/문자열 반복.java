import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            String letter = st.nextToken();
            
            for (int j = 0; j < letter.length(); j++) {
                for (int k = 0; k < n; k++) System.out.print(letter.charAt(j));
            }
            
            System.out.println();
        }
        
        br.close();
    }
}