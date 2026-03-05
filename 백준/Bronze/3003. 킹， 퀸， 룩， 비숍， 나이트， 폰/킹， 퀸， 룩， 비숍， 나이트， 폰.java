import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] ori = br.readLine().split(" ");
        
        int[] now = {1, 1, 2, 2, 2, 8};
        
        for (int i = 0; i < 6; i++) {
            int num = now[i] - Integer.parseInt(ori[i]);
            System.out.print(num + " ");
        }
        
        br.close();
    }
}