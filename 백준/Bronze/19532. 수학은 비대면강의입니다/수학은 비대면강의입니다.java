import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                int equ1 = a * x + b * y;
                
                if (equ1 == c) {
                    int equ2 = d * x + e * y;
                    
                    if (equ2 == f) {
                        System.out.println(x + " " + y);
                        return;
                    }
                }
            }
        }
        
        br.close();
    }
}