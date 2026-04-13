import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 1000000007;
    static int[][] A = {{1, 1}, {1, 0}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        System.out.print(fibonacci(A, n - 1)[0][0]);
        br.close();
    }
    
    private static int[][] fibonacci(int[][] mat, long n) {
        if (n == 1) return A;
        // 단위 행렬 I = A^0 = {{1, 0}, {0, 1}}
        else if (n == 0) return new int[][] {{1, 0}, {0, 1}};
        
        int[][] temp = fibonacci(mat, n / 2);
        int[][] result = pow(temp, temp);
        
        if (n % 2 == 1) result = pow(result, mat);
        
        return result;
    }
    
    private static int[][] pow(int[][] mat1, int[][] mat2) {
        int[][] result = new int[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long element = 0;
                
                for (int k = 0; k < 2; k++) {
                    element += (long) mat1[i][k] * mat2[k][j];
                    element %= MOD;
                }
                
                result[i][j] = (int) element;
            }
        }
        
        return result;
    }
}