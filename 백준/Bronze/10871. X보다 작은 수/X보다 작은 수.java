import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int x = Integer.parseInt(arr[1]);
        
        String[] st = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st[i]) < x) bw.write(st[i] + " ");
        }
        
        br.close();
        bw.close();
    }
}