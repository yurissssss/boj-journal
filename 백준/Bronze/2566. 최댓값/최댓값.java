import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        
        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (num > max) {
                    max = num;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        
        System.out.println(max);
        System.out.print(row + " " + col);
        
        br.close();
    }
}