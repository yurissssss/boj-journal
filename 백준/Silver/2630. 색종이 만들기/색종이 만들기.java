import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int blue = 0;
    static int white = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0, n);
        
        System.out.println(white);
        System.out.print(blue);
        br.close();
    }
    
    private static void dfs(int x, int y, int len) {
        int zero = arr[x][y];
        
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != zero) {
                    dfs(x, y, len / 2);
                    dfs(x + len / 2, y, len / 2);
                    dfs(x, y + len / 2, len / 2);
                    dfs(x + len / 2, y + len / 2, len / 2);
                    
                    /*
                    return의 의미
                    dfs(0, 0, 4) -> dfs(0, 0, 2), dfs(2, 0, 2), dfs(0, 2, 2), dfs(2, 2, 2)
                    dfs(0, 0, 2) -> return;을 만나면
                    dfs(0, 0, 4)로 돌아가서 다음 단계인 dfs(2, 0, 2) 진행
                    */
                    return;
                }
            }
        }
        
        if (zero == 0) white++;
        else blue++;
    }
}