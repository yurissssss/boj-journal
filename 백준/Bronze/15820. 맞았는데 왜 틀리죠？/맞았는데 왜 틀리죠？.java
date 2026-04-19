import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < s1; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            
            if (answer != submit) {
                System.out.print("Wrong Answer");
                return;
            }
        }
        
        for (int i = 0; i < s2; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            
            if (answer != submit) {
                System.out.print("Why Wrong!!!");
                return;
            }
        }
        
        System.out.print("Accepted");
        br.close();
    }
}