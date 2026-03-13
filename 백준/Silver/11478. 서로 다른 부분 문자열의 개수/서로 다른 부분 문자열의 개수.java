import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String letter = br.readLine();
        int len = letter.length();
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            // j = i -> substring(0, 1) -> 0 ~ 0 인덱스 => j = i + 1 부터 시작!
            for (int j = i + 1; j <= len; j++) {
                set.add(letter.substring(i, j));
            }
        }
        
        System.out.println(set.size());
        
        br.close();
    }
}