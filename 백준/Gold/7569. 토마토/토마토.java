import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static int[][][] tomato;
    static int[] dx = {-1, 0, 0, 1, 0, 0};
    static int[] dy = {0, -1, 1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[N][M][H];
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                
                for (int m = 0; m < M; m++) {
                    tomato[n][m][h] = Integer.parseInt(st.nextToken());
                    
                    if (tomato[n][m][h] == 1) {
                        q.offer(new int[]{n, m, h, 0});
                    }
                }
            }
        }
        
        System.out.print(bfs(q));
        
        br.close();
    }
    
    private static int bfs(Queue<int[]> q) {
        boolean[][][] visited = new boolean[N][M][H];
        
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 6; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nh = cur[2] + dh[i];
                    
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H) {
                    if (!visited[nx][ny][nh] && tomato[nx][ny][nh] == 0) {
                        visited[nx][ny][nh] = true;
                        tomato[nx][ny][nh] = 1;
                        q.offer(new int[]{nx, ny, nh, cur[3] + 1});
                     }
                }
            }
            
            if (q.isEmpty()) answer = cur[3];
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (tomato[i][j][k] == 0) return -1;
                }
            }
        }
        
        return answer;
    }
}