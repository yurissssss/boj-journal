import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println("0");
            return;
        }
        
        int x_min = Integer.MAX_VALUE;
        int x_max = Integer.MIN_VALUE;
        int y_min = Integer.MAX_VALUE;
        int y_max = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            x_min = (x < x_min) ? x : x_min;
            x_max = (x > x_max) ? x : x_max;
            y_min = (y < y_min) ? y : y_min;
            y_max = (y > y_max) ? y : y_max;
        }
        
        System.out.println((x_max-x_min)*(y_max-y_min));
        
        br.close();
    }
}