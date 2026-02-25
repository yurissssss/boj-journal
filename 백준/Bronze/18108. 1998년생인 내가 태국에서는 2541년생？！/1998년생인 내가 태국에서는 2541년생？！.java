import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String y = br.readLine();
        int inty = Integer.parseInt(y);
        
        br.close();
        
        System.out.println(inty - 543);
    }
}