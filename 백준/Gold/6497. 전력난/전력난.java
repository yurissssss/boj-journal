import java.io.*;
import java.util.*;

public class Main {
    static class Home implements Comparable<Home> {
        int from;
        int to;
        int dist;
        
        Home(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Home h) {
            return this.dist - h.dist;
        }
    }
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());  // 집
            int n = Integer.parseInt(st.nextToken());  // 거리
            
            if (m == 0 && n == 0) break;
        
            List<Home> list = new ArrayList<>();
            long cost = 0;
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()) ;
                
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                
                cost += d;
                list.add(new Home(f, t, d));
            }
            
            Collections.sort(list);
            
            parent = new int[m];
            for (int i = 0 ; i < m; i++) {
                parent[i] = i;
            }
        
            long sum = 0;
            int count = 0;
            
            for (Home h : list) {
                if (find(h.to) != find(h.from)) {
                    union(h.to, h.from);
                    sum += h.dist;
                    count++;
                }
            
                if (count == m - 1) break;
            }
            
            sb.append(cost - sum).append('\n');
        }
        
        System.out.print(sb);
        br.close();
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }
}