import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] lis = new int[n];
        int max = 0;
        for (int i : arr) {
            int left = 0;
            int right = max;
            
            while (left < right) {
                int mid = (left + right) / 2;
                
                if (lis[mid] < i) left = mid + 1;
                else right = mid;
            }
            
            lis[left] = i;
            if (left == max) max++;
        }
        
        System.out.print(max);
        br.close();
    }
}