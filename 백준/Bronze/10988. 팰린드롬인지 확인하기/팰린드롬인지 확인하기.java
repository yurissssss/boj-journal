import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String ori = br.readLine();
        String rev = new StringBuilder(ori).reverse().toString();
        
        int answer = (rev.equals(ori)) ? 1 : 0;
        
        System.out.println(answer);
        
        br.readLine();
    }
}