import java.io.*;
import java.util.*;

public class Main {
    // 간선 저장 클래스 생성
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
    
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    
        // 정렬기준 'weight'으로 설정
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
    
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Edge> list = new ArrayList<>();
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.add(new Edge(a, b, c));
        }
        
        Collections.sort(list);
        
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
        
        long sum = 0;
        int count = 0;
        
        for (Edge e : list) {
            // 서로 다른 집합이면 연결
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                sum += e.weight;
                count++;
            }
            
            if (count == V - 1) break;
        }
        
        System.out.print(sum);
        br.close();
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 집합 합치기
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}