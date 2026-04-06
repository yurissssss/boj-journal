import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = K;
        int sum = 0;
        for (int i = left; i < right; i++) {
            sum += arr[i];
        }
        int max = sum;
        
        while (right != N) {
            sum = sum - arr[left] + arr[right];
            
            if (sum > max) {
                max = sum;
            }
            
            left++;
            right++;
        }
        
        System.out.print(max);
        br.close();
    }
}