import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 666;
        int count = 0;
        
        while (true) {
            if (String.valueOf(answer).contains("666")) {
                count++;
            }
            
            if (count == n) {
                break;
            }
            
            answer++;
        }
        
        System.out.println(answer);
        br.close();
    }
}