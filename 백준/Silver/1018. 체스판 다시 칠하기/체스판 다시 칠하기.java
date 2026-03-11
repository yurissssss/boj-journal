import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] chess = new String[n];
        
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine();
        }
        
        int answer = Integer.MAX_VALUE;
            
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int paint = paintBoard(chess, i, j);
                answer = Math.min(answer, paint);
            }
        }
        
        System.out.println(answer);
        
        br.close();
    }
    
    private static int paintBoard(String[] col, int n, int m) {
        int b = 0;
        int w = 0;
        int paint = 0;
        
        char now = col[n].charAt(m);
        
        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                char next = col[i].charAt(j);
                
                if ((i + j) % 2 == 0) {
                    if (next != now) paint++;
                } else {
                    if (next == now) paint++;
                }
            }
        }
        
        paint = (paint > 32) ? 64 - paint : paint;
        return paint;
    }
}