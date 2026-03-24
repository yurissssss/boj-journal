import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 세로
        int M = Integer.parseInt(st.nextToken());  // 가로
        int B = Integer.parseInt(st.nextToken());  // 높이
        int[][] ground = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, ground[i][j]);
                min = Math.min(min, ground[i][j]);
            }
        }
        
        int height = max;
        int time = Integer.MAX_VALUE;
        for (int h = min; h <= max; h++) {
            int count = B;
            int sec = 0;
            
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (ground[x][y] > h) {
                        sec += 2 * (ground[x][y] - h);
                        count += ground[x][y] - h;
                    } else if (ground[x][y] < h) {
                        sec += h - ground[x][y];
                        count -= h - ground[x][y];
                    }
                }
            }
            
            if (count >= 0 && sec <= time) {
                time = sec;
                height = h;
            }
        }
        
        System.out.print(time + " " + height);
        br.close();
    }
}