import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] arr;
    static boolean[][] visited;
    
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());  // 가로 길이 (x의 범위)
            N = Integer.parseInt(st.nextToken());  // 세로 길이 (y의 범위)
            K = Integer.parseInt(st.nextToken());  // 배추 위치 개수
            
            arr = new int[M][N];
            visited = new boolean[M][N];
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arr[x][y] = 1;
            }
            
            int count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 좌표의 위치가 범위 내에 ❎ -> 건너뛰기
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            
            if (arr[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
        }
    }
}