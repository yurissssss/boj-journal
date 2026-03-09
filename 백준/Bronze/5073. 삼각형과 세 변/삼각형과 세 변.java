import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String[] st = br.readLine().split(" ");
            int[] side = new int[3];
            
            for (int i = 0; i < 3; i++) {
                side[i] = Integer.parseInt(st[i]);
            }
            if (side[0] == 0) break;
            
            Arrays.sort(side);
            
            String answer = checkTri(side[0], side[1], side[2]);
            System.out.println(answer);
        }
        
        br.close();
    }
   
    private static String checkTri(int a, int b, int c) {
    if (c < (b+a)) {
        if (a == c) return "Equilateral";
        else if ((a==b) || (b==c)) return "Isosceles";
        else return "Scalene";
    }
    return "Invalid";
}
}