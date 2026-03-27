import java.io.*;
import java.util.*;

public class Main {
    static int[] fruit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        fruit = new int[N];
        
        if (N == 1) {
            System.out.print(1);
            return;
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(setFruit(N));
        br.close();
    }
    
    private static int setFruit(int N) {
        int left = 0;
        int len = 2;
        
        int[] count = new int[N + 1];
        count[fruit[0]]++;
        count[fruit[1]]++;
        int size = fruit[0] == fruit[1] ? 1 : 2;
        
        for (int right = 2; right < N; right++) {
            if (count[fruit[right]] == 0) size++;
            count[fruit[right]]++;
            
            while (size > 2) {
                if (count[fruit[left]] == 1) size--;
                count[fruit[left]]--;
                left++;
            }
            
            len = Math.max(len, right - left + 1);
        }
        
        return len;
    }
}