import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String letter = br.readLine();
        
        int num = Integer.parseInt(br.readLine()) - 1;
        
        System.out.println(letter.charAt(num));
        
        br.close();
    }
}