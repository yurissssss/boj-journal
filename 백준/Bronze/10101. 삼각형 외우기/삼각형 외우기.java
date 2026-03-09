import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        checkAngle(a, b, c);
        
        br.close();
    }
    
    private static void checkAngle(int a, int b, int c) {
        String tri = "Error";
        
        if (a+b+c == 180) {
            if ((a==b) && (b==c)) tri = "Equilateral";
            else if ((a==b) || (b==c) || (c==a)) tri = "Isosceles";
            else tri = "Scalene";
        }
        
        System.out.println(tri);
    }

}