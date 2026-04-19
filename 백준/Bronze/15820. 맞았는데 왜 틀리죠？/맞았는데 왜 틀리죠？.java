import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        
        boolean sampleCorrect = true;
        boolean systemCorrect = true;
        
        for (int i = 0; i < s1; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            
            if (answer != submit) sampleCorrect = false;
        }
        
        for (int i = 0; i < s2; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = Integer.parseInt(st.nextToken());
            int submit = Integer.parseInt(st.nextToken());
            
            if (answer != submit) systemCorrect = false;
        }
        if (!sampleCorrect) System.out.println("Wrong Answer");
        else if (!systemCorrect) System.out.println("Why Wrong!!!");
        else System.out.println("Accepted");
        br.close();
    }
}