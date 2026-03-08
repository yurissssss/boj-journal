import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        for (int i=1; i<=num; i++) {
            if ((num%i == 0) && (++count == index)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
        
        br.close();
    }
}