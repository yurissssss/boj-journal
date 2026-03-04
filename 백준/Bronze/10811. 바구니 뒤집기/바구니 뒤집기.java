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
            
            /*
            int a = Integer.parseInt(nums.nextToken());
            int b = Integer.parseInt(nums.nextToken());
            
            for (int j = a-1; j < (a+b-1)/2; j++) {
                int temp = arr[a+b-j-2];
                arr[a+b-j-2] = arr[j];
                arr[j] = temp;
            }
            */
            
            int left = Integer.parseInt(nums.nextToken()) - 1;
            int right = Integer.parseInt(nums.nextToken()) - 1;
            
            while (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + " ");
        }
        
        br.close();
        bw.close();
        
    }
}