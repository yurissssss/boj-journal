import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }
        
        setStar(0, 0 ,n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static void setStar(int x, int y, int n) {
        if (n == 1) return;
        
        int size = n / 3;
        
        // 가운데 칸 공백 처리
        for (int i = x + size; i < x + size * 2; i++) {
            for (int j = y + size; j < y + size * 2;j++) {
                arr[i][j] = ' ';
            }
        }
        
        // 가운데 칸 제외하고 무늬 반복
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;  // 가운데 칸 제외
                setStar(x + size * i, y + size * j, size);
            }
        }
    }
}