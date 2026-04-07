import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N - 1];
        long[] price = new long[N - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }
        
        long answer = 0;
        long gas = 0;
        long min = price[0];
        for (int i = 0; i < N - 1; i++) {
            if (price[i] <= min) {
                answer += price[i] * dist[i];
                min = price[i];
            } else {
                answer += min * dist[i];
            }
        }
        
        System.out.print(answer);
        br.close();
    }
}