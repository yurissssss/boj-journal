import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double sum = 0.0;
        double count = 0.0;
        
        for(int i = 0; i < 20; i++) {
            String[] st = br.readLine().split(" ");
            double score = Double.parseDouble(st[1]);
            
            if (!st[2].equals("P")) {
                switch(st[2]) {
                    case "A+":
                        sum += score * 4.5;
                        break;
                        
                    case "A0":
                        sum += score * 4.0;
                        break;
                        
                    case "B+":
                        sum += score * 3.5;
                        break;
                        
                    case "B0":
                        sum += score * 3.0;
                        break;
                        
                    case "C+":
                        sum += score * 2.5;
                        break;
                        
                    case "C0":
                        sum += score * 2.0;
                        break;
                        
                    case "D+":
                        sum += score * 1.5;
                        break;
                        
                    case "D0":
                        sum += score * 1.0;
                        break;
                        
                    default:
                        sum += score * 0.0;
                }
                count += score;
            }
        }
        System.out.println(sum/count);
        br.close();
    }
}