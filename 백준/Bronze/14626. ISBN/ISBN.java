import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int sum = 0;
        boolean isOdd = false;
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '*') {
                isOdd = (i + 1) % 2 == 0 ? false : true;
            } else if ((i + 1) % 2 == 0) sum += (c - '0') * 3;
            else sum += (c - '0');
        }
        
        if (isOdd) {
            answer = sum % 10 == 0 ? 0 : 10 - sum % 10;
        } else {
            if (sum % 10 == 0) answer = 0;
            else {
                int rest = 10 - sum % 10;
                for (int i = 1; i < 9; i++) {
                    if (3 * i % 10 == rest) {
                        answer = i;
                        break;
                    }
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}