import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] mat = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        /*
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                int sum = Integer.parseInt(st.nextToken()) + mat[i][j];
                if (j == m-1) System.out.println(sum);
                else System.out.print(sum + " ");
            }
        }
        */
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (j == m-1) sb.append(mat[i][j] + Integer.parseInt(st.nextToken()));
                else sb.append(mat[i][j] + Integer.parseInt(st.nextToken())).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
        br.close();
    }
}