import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer nums = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(nums.nextToken()) - 1;
            int b = Integer.parseInt(nums.nextToken()) - 1;
            
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }
        
        br.close();
        bw.close();
        
    }
}