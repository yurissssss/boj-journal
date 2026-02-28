import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        
        br.close();
        
        System.out.println(setAlarm(hour, min));
    }
    
    private static String setAlarm(int h, int m){
        if (m >= 45) m-= 45;
        else if (h == 0) {
            h = 23;
            m += 15;
        }
        else {
            h -= 1;
            m += 15;
        }
        
        return (h + " " + m);
    }
}