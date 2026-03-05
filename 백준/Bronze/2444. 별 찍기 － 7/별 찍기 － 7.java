import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num-i-1; j++) System.out.print(" ");
            for (int j = 0; j < (2*i+1); j++) System.out.print("*");
            System.out.println();
        }
        
        for (int i = num-2; i >= 0; i--) {
            for (int j = 0; j < num-i-1; j++) System.out.print(" ");
            for (int j = 0; j < (2*i+1); j++) System.out.print("*");
            System.out.println();
        }
        
        br.close();
    }
}