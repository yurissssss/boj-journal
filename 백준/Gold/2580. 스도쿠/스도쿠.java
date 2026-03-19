import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static List<int[]> empty = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        arr = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        
        dfs(0);
        
        br.close();
    }
    
    private static void dfs(int depth) {
        if (depth == empty.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            
            // 'return;' 하면 상위 depth의 dfs로 돌아감
            // 다른 문제들은 모든 경우의 수를 탐색해서 'return;'이 가능했지만
            // 여기서는 빈칸만 탐색하므로 불가능!
            System.exit(0);
        }
        
        int[] now = empty.get(depth);
        int row = now[0];
        int col = now[1];
        
        for (int i = 1; i <= 9; i++) {
            arr[row][col] = i;
            
            if (isPossible(row, col)) {
                dfs(depth + 1);
            }
            
            // 만약 실패하고 돌아올 경우 -> 초기화
            arr[row][col] = 0;
        }
    }
    
    private static boolean isPossible(int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != col && arr[row][i] == arr[row][col]) return false;
            if (i != row && arr[i][col] == arr[row][col]) return false;
        }
        
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (!(i == row && j == col) && arr[row][col] == arr[i][j]) return false;
            }
        }
        
        return true;
    }
}