import java.io.*;
import java.util.*;

public class Main {
    static class Cosmic implements Comparable<Cosmic> {
        int from;
        int to;
        double dist;
        
        Cosmic(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Cosmic c) {
            return Double.compare(this.dist, c.dist);
        }
    }
     
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] coord = new int[N + 1][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coord[i + 1][0] = Integer.parseInt(st.nextToken());
            coord[i + 1][1] = Integer.parseInt(st.nextToken());
        }
        
        List<Cosmic> list = new ArrayList<>();
        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                double d = Math.hypot(coord[i][0] - coord[j][0], coord[i][1] - coord[j][1]);
                
                list.add(new Cosmic(i, j, d));
            }
        }
        
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            union(a, b);
        }
        
        Collections.sort(list);
        
        double sum = 0;
        for (Cosmic c : list) {
            if (find(c.from) != find(c.to)) {
                union(c.from, c.to);
                sum += c.dist;
            }
        }
        
        System.out.printf("%.2f", sum);
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