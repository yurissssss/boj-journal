import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        for (int i = 1; i<=45; i++) {
            num -= i;
            
            if (num == 0) {
                System.out.println("1 " + i);
                break;
            }
            else if (num < 0)  {
                System.out.println((1-num) + " " + (num+i));
                break;
            }
        }
        br.close();
    }
}