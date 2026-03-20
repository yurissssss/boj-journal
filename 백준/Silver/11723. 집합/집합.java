import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int x = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            
            switch (order) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;
                    
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;
                    
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append(set.contains(x) ? 1 : 0).append('\n');
                    break;
                    
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                    break;
                    
                case "all":
                    if (!set.isEmpty()) set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                    
                default:
                    set.clear();
            }
        }     
        System.out.print(sb);
        br.close();
    }
}