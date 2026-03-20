import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;
        int cur = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            sum += cur;
        }
        
        System.out.print(sum);
        
        br.close();
    }
}