import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Long B;
    static int[][] A;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] answer = pow(A, B);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        
        br.close();
    }
    
    private static int[][] pow(int[][] mat, long exp) {
        if (exp == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mat[i][j] %= 1000;
                }
            }
            
            return mat;
        }
        
        int[][] temp = pow(mat, exp / 2);
        int[][] result = multiply(temp, temp);
        
        if (exp % 2 == 1) {
            result = multiply(result, mat);
        }
        
        return result;
    }
    
    private static int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        
        return result;
    }
}