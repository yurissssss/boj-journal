import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        
        /*
        10 = 2 x 5, 100 = 2^2 x 5^2
        -> 뒷자리 '0'의 개수는 소인수분해 시 5의 개수와 같음
           (2는 많이 포함되어 있으므로 없다고 생각해도 🅾️)
        --> n/5, n/25, n/125 ... 구해서 더하기
        *** 반복하면서 자동으로 25(2번), 125(3번)가 포함된 경우가 중복 -> 가중치 필요 ❎
        */
        
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        
        System.out.print(count);
        
        br.close();
    }
}