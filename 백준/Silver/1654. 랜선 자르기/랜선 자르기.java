import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lines = new int[N];
        
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(binarySearch(lines, N, K));
        br.close();
    }
    
    private static long binarySearch(int[] lines, int N, int K) {
        long left = 1;
        long right = Arrays.stream(lines).max().getAsInt();
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int line : lines) {
                count += line / mid;
            }
            
            if (count >= K) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}