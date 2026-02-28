import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        int n = num/4;
        
        for (int i=0; i<n; i++) {
            System.out.print("long ");
        }
        
        br.close();
        
        System.out.print("int");
    }
}