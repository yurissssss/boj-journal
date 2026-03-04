import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] origin = new int[9];
        int[] arr = new int[9];
        
        for (int i = 0; i < 9; i++) {
            origin[i] = Integer.parseInt(br.readLine());
            arr[i] = origin[i];
        }
        
        Arrays.sort(arr);
        
        for (int i = 0; i < 9; i++) {
            if (origin[i] == arr[8]) {
                bw.write(origin[i] + "\n" + (i+1) + "\n");
                break;
            }
        }
        
        br.close();
        bw.close();
    }
}