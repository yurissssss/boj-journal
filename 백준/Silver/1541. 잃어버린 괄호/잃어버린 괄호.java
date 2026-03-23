import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = br.readLine();
        int idx = st.indexOf('-') == -1 ? st.length() : st.indexOf('-');
        int sum = 0;
        String s = "";
        
        for (int i = 0; i < idx; i++) {
            char c = st.charAt(i);
            
            if (c != '-' && c != '+') s += c;
            else {
                sum += Integer.parseInt(s);
                s = "";
            }
            
            if (i == idx - 1) {
                sum += Integer.parseInt(s);
                s = "";
            }
        }
        for (int i = idx + 1; i < st.length(); i++) {
            char c = st.charAt(i);
            
            if (c != '-' && c != '+') s += c;
            else {
                sum -= Integer.parseInt(s);
                s = "";
            }
            
            if (i == st.length() - 1) {
                sum -= Integer.parseInt(s);
            }
        }
        
        System.out.print(sum);
        br.close();
    }
}