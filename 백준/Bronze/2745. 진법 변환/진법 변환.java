import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String letter = st.nextToken();
        int len = letter.length() - 1;
        int num = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        for (char c : letter.toCharArray()) {
            if (c >= 'A') answer += (c - 'A' + 10) * Math.pow(num, len);
            else answer += (c - '0') * Math.pow(num, len);
            len--;
        }
        
        System.out.println(answer);
        
        br.close();
    }
}