import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] time = br.readLine().split(" ");
        
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        int due = Integer.parseInt(br.readLine());
        
        br.close();
        
        System.out.println(setOven(hour, min, due));
    }
    
    private static String setOven(int h, int m, int d) {
        int mins = h*60 + m;
        int time = mins + d;
        
        if (time >= 1440) {
            time -= 1440;
        }
        
        h = time/60;
        m = time%60;
        
        return (h + " " + m);
    }
}