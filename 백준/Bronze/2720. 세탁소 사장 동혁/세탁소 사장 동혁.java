import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        for (int i=0; i<num; i++) {
            int amount = Integer.parseInt(br.readLine());
            
            System.out.print(amount/25 + " ");
            amount %= 25;
            System.out.print(amount/10 + " ");
            amount %= 10;
            System.out.print(amount/5 + " ");
            amount %= 5;
            System.out.println(amount);
        }
        
        br.close();
    }
}