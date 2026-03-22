import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static boolean[] visited;
    static Map<Integer, List<Integer>> map;
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        visited[1] = true;
        m = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 처음 입력받은 값이라면 새로운 list 생성
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            
            // 양방향으로 추가
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        System.out.print(dfs(1));
        
        br.close();
    }
    
    private static int dfs(int n) {
        if (!map.containsKey(n)) return set.size();
        
        for (int i : map.get(n)) {
            if (!visited[i]) {
                set.add(i);
                visited[i] = true;
                dfs(i);
            }
        }
        
        return set.size();
    }
}