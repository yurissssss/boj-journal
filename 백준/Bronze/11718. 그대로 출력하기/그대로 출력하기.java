import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String letter;
        
        while((letter = br.readLine()) != null) {
            System.out.println(letter);
        }
        
        br.close();
    }
}