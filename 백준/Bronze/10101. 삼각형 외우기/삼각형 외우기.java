import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        String answer = checkAngle(a, b, c);
        System.out.println(answer);
        
        br.close();
    }
    
    private static String checkAngle(int a, int b, int c) {
        if (a+b+c == 180) {
            if ((a==b) && (b==c)) return "Equilateral";
            else if ((a==b) || (b==c) || (c==a)) return "Isosceles";
            else return "Scalene";
        }
        return "Error";
    }

}