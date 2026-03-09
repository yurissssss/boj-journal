import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int[] side = new int[3];
        
        for (int i = 0; i < 3; i++) {
            side[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(side);
        
        int sum = makeTri(side[0], side[1], side[2]);
        System.out.println(sum);
        
        br.close();
    }
    
    private static int makeTri(int a, int b, int c) {
        if ((a + b) <= c) c = a + b - 1;
        return (a + b + c);
    }
}