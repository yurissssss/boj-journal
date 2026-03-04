import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char letter = br.readLine().charAt(0);
        
        System.out.println((int)letter);
        
        br.close();
        */
        
        System.out.println((int)System.in.read());
    }
}