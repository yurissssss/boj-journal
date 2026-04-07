import java.io.*;
import java.util.*;

public class Main {
    static Map<String, List<String>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            
            map.put(parent, new ArrayList<>());
            map.get(parent).add(left);
            map.get(parent).add(right);
        }
        
        preorderTraversal("A");
        sb.append('\n');
        inorderTraversal("A");
        sb.append('\n');
        postorderTraversal("A");
        
        System.out.print(sb);
        br.close();
    }
    
    private static void preorderTraversal(String cur) {
        if (cur.equals(".")) return;
        
        sb.append(cur);
        
        for (String s : map.get(cur)) {
            preorderTraversal(s);
        }
    }
    
    private static void inorderTraversal(String cur) {
        if (cur.equals (".")) return;
        
        List<String> children = map.get(cur);
        
        // 왼쪽 탐색 -> return -> 루트 -> 오른쪽 탐색
        inorderTraversal(children.get(0));
        sb.append(cur);
        inorderTraversal(children.get(1));
    }
    
    private static void postorderTraversal(String cur) {
        if (cur.equals (".")) return;
        
        List<String> children = map.get(cur);
        
        /* 
        왼쪽 탐색 -> 가장 아래 왼쪽 만남 -> 오른쪽 탐색 -> . -> return -> sb.append
        -> 자동으로 return -> 오른쪽 탐색 -> . -> reuturn -> sb.append
        -> 자동으로 return -> 루트 -> 오른쪽 탐색
        -> 다시 왼쪽 탐색 -> ... -> 마지막에 자동으로 return 되어 루트 sb.append
        */
        postorderTraversal(children.get(0));
        postorderTraversal(children.get(1));    
        sb.append(cur);    
    }
}