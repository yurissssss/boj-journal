import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] students = new int[30];
        
        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;
            
            students[num] = 1;
        }
        
        int[] answer = new int[2];
        
        for (int i = 0; i < 30; i++) {
            if (students[i] == 0) {
                bw.write((i+1) + "\n");
            }
        }
        
        br.close();
        bw.close();
    }
}