import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        for (int i = 0; i < num; i++) {
            answer += (Integer.parseInt(st[i]) == x) ? 1 : 0;
        }
        
        bw.write(answer + "\n");
        
        br.close();
        bw.close();
    }
}