import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (br.readLine().equals("W")) count++;
        }
        
        switch (count) {
            case 6: case 5:
                System.out.print("1");
                break;
                
            case 4: case 3:
                System.out.print("2");
                break;
                
            case 2: case 1:
                System.out.print("3");
                break;
                
            default:
                System.out.print("-1");
        }
        br.close();
    }
}