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
        
        int[][] mat1 = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] mat2 = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                mat2[i][j] = Integer.parseInt(st.nextToken()) + mat1[i][j];
                if (j == m-1) System.out.println(mat2[i][j]);
                else System.out.print(mat2[i][j] + " ");
            }
        }
        
        br.close();
    }
}