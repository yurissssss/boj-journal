import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        int zone = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count = 1;
                    dfs(i, j);
                    zone++;
                    list.add(count);
                }
            }
        }
        sb.append(zone);
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            sb.append('\n').append(list.get(i));
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    count++;
                    dfs(nx, ny);
                }
            }
        }
    }
}