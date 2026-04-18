import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bulb = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            switch (order) {
                case 1:
                    bulb[a - 1] = b;
                    break;
                    
                case 2:
                    for (int j = a; j <= b; j++) {
                        bulb[j - 1] = bulb[j - 1] == 0 ? 1 : 0;
                    }
                    break;
                    
                case 3:
                    for (int j = a; j <= b; j++) {
                        bulb[j - 1] = 0;
                    }
                    break;
                    
                default:
                    for (int j = a; j <= b; j++) {
                        bulb[j - 1] = 1;
                    }
            }
        }
        
        for (int i = 0; i < n; i++) {
            sb.append(bulb[i]).append(' ');
        }
        
        System.out.print(sb);
        br.close();
    }
}