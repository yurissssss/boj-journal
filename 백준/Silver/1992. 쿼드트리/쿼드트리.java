import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
          
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        dfs(N, 0, 0);
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int len, int x, int y) {
        int start = 0;
        boolean isSame = true;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                start = arr[x][y];
                
                if (arr[i][j] != start) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }
        
        if (isSame) {
            sb.append(start);
            return;
        }
        
        sb.append('(');
        dfs(len / 2, x, y);
        dfs(len / 2, x, y + len / 2);
        dfs(len / 2, x + len / 2, y);
        dfs(len / 2, x + len / 2, y + len / 2);
        sb.append(')');
    }
}