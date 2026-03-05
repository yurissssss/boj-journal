import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] str) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        String up = st.toUpperCase();
        
        int[] alp = new int[26];
        
        for (int i = 0; i < up.length(); i++) {
            int index = up.charAt(i) - 'A';
            alp[index]++;
        }
        
        int max = -1;
        char answer = '?';
        
        for (int i = 0; i < 26; i++) {
            if (alp[i] > max) {
                max = alp[i];
                answer = (char)(i + 'A');
            } else if (alp[i] == max) {
                answer = '?';
            }
        }
        
        System.out.println(answer);
        
        br.readLine();
    }
}