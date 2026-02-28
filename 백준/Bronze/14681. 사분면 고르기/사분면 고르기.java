import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        br.close();
        
        if (x > 0) {
            if (y > 0) System.out.println("1");
            else System.out.println("4");
        } else {
            if (y > 0) System.out.println("2");
            else System.out.println("3");
        }
    }
}