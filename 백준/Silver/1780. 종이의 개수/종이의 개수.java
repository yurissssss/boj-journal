import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int[][] arr;
    static int[] answer = new int[3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(N, 0, 0);
        
        for (int i : answer) {
            System.out.println(i);
        }
        br.close();
    }
    
    private static void dfs(int len, int x, int y) {
        int start = arr[x][y];
        boolean isSame = true;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != start) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }
        
        if (isSame) {
            answer[start + 1]++;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(len / 3, x + len / 3 * i, y + len / 3 * j);
            }
        }
    }
}