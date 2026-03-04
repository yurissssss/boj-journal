import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < num; i++) {
            String letter = br.readLine();
            int len = letter.length();
        
            System.out.print(letter.charAt(0));
            System.out.println(letter.charAt(len-1));
        }
        
        br.close();
    }
}