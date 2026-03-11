import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int answer = n / 3 + 1;
        
        for (int i = 0; i <= (n / 3); i++) {
            for (int j = 0; j <= (n / 5 + 1); j++) {
                if (3 * i + 5 * j == n) {
                    answer = Math.min(answer, (i + j));
                }
            }
        }
        
        if (answer > n / 3) answer = -1;
        
        System.out.println(answer);
        br.close();
    }
}