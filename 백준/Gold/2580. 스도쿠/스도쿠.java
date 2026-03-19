import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr = new int[9][9];
    static List<int[]> empty = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
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
                for (int j = 0; j < 9; j++) sb.append(arr[i][j]).append(" ");
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        
        int row = empty.get(depth)[0];
        int col = empty.get(depth)[1];
        
        for (int i = 1; i <= 9; i++) {
            arr[row][col] = i;
            
            if (isPossible(row, col)) dfs(depth + 1);
            
            arr[row][col] = 0;
        }
    }
    
    private static boolean isPossible(int r, int c) {
        for (int i = 0; i < 9; i++) {
            if ((i != r) && (arr[i][c] == arr[r][c])) return false;
            if ((i != c) && (arr[r][i] == arr[r][c])) return false;
        }
        
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (!(i == r && j == c) && (arr[i][j] == arr[r][c])) return false;
            }
        }
        
        return true;
    }
}