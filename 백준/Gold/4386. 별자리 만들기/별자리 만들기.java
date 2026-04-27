import java.io.*;
import java.util.*;

public class Main {
    static class Star implements Comparable<Star> {
        int from;
        int to;
        double dist;
        
        Star(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
        
        // compareTo는 반드시 "int"로 반환!
        @Override
        public int compareTo(Star s) {
            return Double.compare(this.dist, s.dist);
        }
    }
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        double[][] coord = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coord[i][0] = Double.parseDouble(st.nextToken());
            coord[i][1] = Double.parseDouble(st.nextToken());
        }
        
        List<Star> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    double dx = coord[i][0] - coord[j][0];
                    double dy = coord[i][1] - coord[j][1];
                    double d = Math.sqrt(dx * dx + dy * dy);
                    
                    list.add(new Star(i, j, d));
                }
            }
        }
        
        Collections.sort(list);
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        double sum = 0;
        int count = 0;
        
        for (Star s : list) {
            if (find(s.from) != find(s.to)) {
                union(s.from, s.to);
                sum += s.dist;
                count++;
            }
            
            if (count == n - 1) break;
        }
        
        System.out.printf("%.2f", sum);
        br.close();
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int root1 = parent[x];
        int root2 = parent[y];
        
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }
}