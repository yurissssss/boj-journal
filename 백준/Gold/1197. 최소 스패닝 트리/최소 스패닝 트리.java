import java.io.*;
import java.util.*;

public class Main {
    // 간선 정보 저장 클래스 <- 정렬 기준 제공
    // implements Comparable<Edge>: Edge끼리 어떻게 크기 비교할지 정해줌
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
    
        Edge (int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    
        // 'weight'를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    
    // Union-Find에서 사용하는 배열 -> 각 노드의 부모 정보 저장
    static int[] parent;
    
    // 가중치가 작은 간선부터 보면서 사이클이 생기지 않을 때만 선택!
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
        
        // compareTo()로 미리 설정한 기준을 따라 정렬
        // -> weight 기준으로 오름차순
        Collections.sort(list);
        
        // 각 노드가 자기 자신의 값만 가지도록 초기화
        // -> 모든 노드가 각각 떨어져 있는 상황
        parent = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
        
        long sum = 0;
        int count = 0;
        
        // 가중치가 작은 간선부터 확인
        for (Edge e : list) {
            /* 
            e.from / e.to 가 속한 집합의 대표 찾기
            -> 둘이 다르면: 아직 연결 안 된 상태
            -> 둘이 같으면: 이미 연결된 상태 (사이클 발생)
            --> 서로 다른 집합이면 연결
            */
            if (find(e.from) != find(e.to)) {
                // 연결 가능하면 -> 두 집합을 하나로 합치기
                union(e.from, e.to);
                sum += e.weight;
                count++;
            }
            
            // MST 완성 -> 종료
            if (count == V - 1) break;
        }
        
        System.out.print(sum);
        br.close();
    }
    
    // x가 속한 집합의 대표(루트) 찾는 함수
    private static int find(int x) {
        // 자기 자신이 부모 -> 그 노드가 대표
        if (parent[x] == x) return x;
        
        /* 
        부모를 따라 올라가서 최종 대표 찾기
        int root = find(parent[x]);  // 루트 찾기
        parent[x] = root;            // 부모를 루트로 갱신 (경로 압축)
        return root;                 // 루트 반환
        */
        
        /*
        경로압축
        ❎ return find(parent[x]); 
        🅾️ return parent[x] = find(parent[x]);
        중간 노드들의 부모도 바로 대표로 바꿔줌
        -> 나중에 같은 노드의 대표를 다시 찾을 때 훨씬 빨라짐
        */
        return parent[x] = find(parent[x]);
    }
    
    // 두 집합을 하나로 합치는 함수
    private static void union(int a, int b) {
        // 각 집합의 대표 찾기
        // -> a, b를 바로 합치기 ❎, 대표끼리 합치기 🅾️
        int rootA = find(a);
        int rootB = find(b);
        
        // 대표 다름 -> 서로 다른 집합 --> 합치기
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}