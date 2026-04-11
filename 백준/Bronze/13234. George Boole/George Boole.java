import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        
        if (b.equals("AND")) {
            if (a.equals("false") || c.equals("false")) {
                System.out.print("false");
            } else {
                System.out.print("true");
            }
        } else {
            if (a.equals("false") && c.equals("false")) {
                System.out.print("false");
            } else {
                System.out.print("true");
            }
        }
        
        br.close();
    }
}