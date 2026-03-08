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
        
        int answer = findFactor(num, index);
            
        System.out.println(answer);
        
        br.close();
    }
    
    public static int findFactor(int n, int k) {
        int count = 0;
        
        for (int i=1; i<=n; i++) {
            if ((n%i == 0) && (++count == k)) return i;
        }
        
        return 0;
    }
}