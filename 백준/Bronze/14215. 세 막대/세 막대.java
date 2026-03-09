import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] side = new int[3];
        
        for (int i = 0; i < 3; i++) {
            side[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(side);
        
        int sum = makeTri(side[0], side[1], side[2]);
        System.out.println(sum);
        
        br.close();
    }
    
    private static int makeTri(int a, int b, int c) {
        if ((a + b) <= c) return (a + b) * 2 - 1;
        return a + b + c;
    }
}