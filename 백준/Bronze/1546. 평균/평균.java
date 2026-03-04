import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        double[] scores = new double[num];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < num; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
        }
        
        Arrays.sort(scores);
        
        double max = scores[num-1];
        double sum = 0;
        
        for (int i = 0; i < num; i++) {
            sum += (double)scores[i]/max*100;
        }
      
        System.out.println(sum / num);
        
        br.close();
        
    }
}