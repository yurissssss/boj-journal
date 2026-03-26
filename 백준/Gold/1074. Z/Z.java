import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;

        while (N > 0) {
            int size = 1 << N - 1;  // 사분면 기준
            int area = size * size;  // 사분면 크기
            
            if (r < size && c < size) {
                // 1사분면
            } else if (r < size && c >= size) {
                // 2사분면
                answer += area;
                c -= size;
            } else if (r >= size && c < size) {
                // 3사분면
                answer += 2 * area;
                r -= size;
            } else {
                // 4사분면
                answer += 3 * area;
                r -= size;
                c -= size;
            }

            N--;
        }

        System.out.print(answer);
        br.close();
    }
}