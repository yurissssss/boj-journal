import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        dfs(0);
        
        System.out.print(count);
        
        br.close();
    }
    
    private static void dfs(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        
        /*
        퀸은 상하좌우대각선 중 한 방향으로 마음껏 움직일 수 있음
         -> 한 행에 퀸 한 개씩 배치
         --> arr[row] = col -> row행의 col열
        */
        
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }
    
    private static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            // 같은 열에 위치해 있는 퀸이 있다면
            if (arr[i] == arr[depth]) return false;
            
            // 대각선에 위치해 있는 퀸이 있다면
            if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
        }
        
        return true;
    }
}