import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int m = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        
        if (n > m) System.out.println(n);
        else System.out.println(m);
        
        br.close();
    }
}