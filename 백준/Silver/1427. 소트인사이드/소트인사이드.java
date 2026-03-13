import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int len = s.length();
        int[] arr = new int[s.length()];
        
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = len - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        
        System.out.print(sb);
        
        br.close();
    }
}