import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" "); 
        
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st[i]);
        }
        
        int min = findMin(num);
        
        System.out.println(min);
        
        br.close();
    }
    
    private static int findMin(int[] n) {
        int min = (n[0] < n[1]) ? n[0] : n[1]; 
        
        min = ((n[2]-n[0]) < min) ? n[2]-n[0] : min;
        min = ((n[3]-n[1]) < min) ? n[3]-n[1] : min;
        
        return min;
    }
}