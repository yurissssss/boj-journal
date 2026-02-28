import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        
        int amount = 0;
        int price = 0;
        int num = 0;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            price = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            
            amount += price*num;
        }
        
        br. close();
        
        if (amount == total) System.out.println("Yes");
        else System.out.println("No");
    }
}