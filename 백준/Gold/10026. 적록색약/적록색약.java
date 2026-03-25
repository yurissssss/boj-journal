import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.charAt(j);
            }
        }
        
        visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfsRGB(i, j);
                    count++;
                }
            }
        }
        System.out.print(count + " ");
        
        visited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfsRB(i, j);
                    count++;
                }
            }
        }
        System.out.print(count);
        
        br.close();
    }
    
    private static void dfsRGB(int x, int y) {
        visited[x][y] = true;
        char c = arr[x][y];
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && arr[nx][ny] == c) {
                    dfsRGB(nx, ny);
                }
            }
        }
    }
    
    private static void dfsRB(int x, int y) {
        visited[x][y] = true;
        char c = isSameColor(arr[x][y]);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (!visited[nx][ny] && isSameColor(arr[nx][ny]) == c) {
                    dfsRB(nx, ny);
                }
            }
        }
    }
    
    private static char isSameColor(char c) {
        if (c == 'G') return 'R';
        else return c;
    }
}