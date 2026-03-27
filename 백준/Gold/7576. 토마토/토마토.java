import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] tomato;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int answer = -1;  // 이미 익어있는 토마토로 시작
        while (!q.isEmpty()) {
            bfs(q);
            answer++;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        
        System.out.print(answer);
        br.close();
    }
    
    private static void bfs(Queue<int[]> q) {
        int size = q.size();
        
        for (int n = 0; n < size; n++) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}