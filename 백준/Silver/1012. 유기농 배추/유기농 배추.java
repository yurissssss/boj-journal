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
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());  // 가로 길이
            N = Integer.parseInt(st.nextToken());  // 세로 길이
            K = Integer.parseInt(st.nextToken());  // 배추 위치 개수
            
            arr = new int[N][M];
            visited = new boolean[N][M];
            
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arr[y][x] = 1;
            }
            
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
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
            
            // 범위 내에 ❎ -> 건너뛰기
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if (arr[nx][ny] == 1 && !visited[nx][ny]) dfs(nx, ny);
        }
    }
}