import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] arr;
    static int count = 0;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        
        visited = new boolean[N][M];
        dfs(x, y);
            
        System.out.print(count == 0 ? "TT" : count);
        br.close();
    }
    
    private static void dfs(int x, int y) {
        if (!visited[x][y]) {
            char cur = arr[x][y];
            
            if (cur != 'X') {
                if (cur == 'P') count++;
                
                visited[x][y] = true;
                
                if (x - 1 >= 0) dfs(x - 1, y);
                if (x + 1 < N) dfs(x + 1, y);
                if (y - 1 >= 0) dfs(x, y - 1);
                if (y + 1 < M) dfs(x, y + 1);
            } else return;
        }
    }
}