import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        br.close();
        
        System.out.println(quadrant(x, y));
    }
    
    private static int quadrant(int x, int y) {
        int q = 0;
        if (x > 0) q = (y > 0) ? 1 : 4;
        else q = (y > 0) ? 2 : 3; 
        
        return q;
    }
}