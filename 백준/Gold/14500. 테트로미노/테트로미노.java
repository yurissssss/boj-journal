import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
                checkT(i, j);
            }
        }
        
        System.out.print(answer);
        br.close();
    }
    
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
    
    private static void checkT(int x, int y) {
        // 상, 하, 좌, 우 중 3개를 선택
        int center = arr[x][y];

        // ㅗ
        if (x - 1 >= 0 && y - 1 >= 0 && y + 1 < m) {
            int sum = center + arr[x - 1][y] + arr[x][y - 1] + arr[x][y + 1];
            answer = Math.max(answer, sum);
        }

        // ㅜ
        if (x + 1 < n && y - 1 >= 0 && y + 1 < m) {
            int sum = center + arr[x + 1][y] + arr[x][y - 1] + arr[x][y + 1];
            answer = Math.max(answer, sum);
        }

        // ㅓ
        if (x - 1 >= 0 && x + 1 < n && y - 1 >= 0) {
            int sum = center + arr[x - 1][y] + arr[x + 1][y] + arr[x][y - 1];
            answer = Math.max(answer, sum);
        }

        // ㅏ
        if (x - 1 >= 0 && x + 1 < n && y + 1 < m) {
            int sum = center + arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1];
            answer = Math.max(answer, sum);
        }
    }
}