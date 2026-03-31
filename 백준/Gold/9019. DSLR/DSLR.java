import java.io.*;
import java.util.*;

class Resist {
    int num;
    String order;
    
    Resist(int num, String order) {
        this.num = num;
        this.order = order;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int before = 0;
        int after = 0;
        
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());
             
            sb.append(bfs(before, after)).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static String bfs(int start, int target) {
        Queue<Resist> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        
        q.offer(new Resist(start, ""));
        visited[start] = true;
        
        while (!q.isEmpty()) {
            Resist cur = q.poll();
            
            if (cur.num == target) return cur.order;
            
            if (!visited[playD(cur.num)]) {
                visited[playD(cur.num)] = true;
                q.offer(new Resist(playD(cur.num), cur.order + "D"));
            }
            
            if (!visited[playS(cur.num)]) {
                visited[playS(cur.num)] = true;
                q.offer(new Resist(playS(cur.num), cur.order + "S"));
            }
            
            if (!visited[playL(cur.num)]) {
                visited[playL(cur.num)] = true;
                q.offer(new Resist(playL(cur.num), cur.order + "L"));
            }
            
            if (!visited[playR(cur.num)]) {
                visited[playR(cur.num)] = true;
                q.offer(new Resist(playR(cur.num), cur.order + "R"));
            }
        }
        
        return "";
    }
    
    private static int playD(int n) {
        n *= 2;
        if (n > 9999) n %= 10000;
        return n;
    }
    
    private static int playS(int n) {
        n -= 1;
        if (n < 0) n += 10000;
        return n;
    }
    
    private static int playL(int n) {
        int[] arr = new int[4];
        for (int i = 3; i >= 0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        
        return (((arr[1] * 10 + arr[2]) * 10 + arr[3]) * 10 + arr[0]);
    }
    
    private static int playR(int n) {
        int[] arr = new int[4];
        for (int i = 3; i >= 0; i--) {
            arr[i] = n % 10;
            n /= 10;
        }
        
        return (((arr[3] * 10 + arr[0]) * 10 + arr[1]) * 10 + arr[2]);
    }    
}