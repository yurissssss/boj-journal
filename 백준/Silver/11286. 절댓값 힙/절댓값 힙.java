import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if (x != 0) {
                map.putIfAbsent(Math.abs(x), new ArrayList<>());
                map.get(Math.abs(x)).add(x);
            } else {
                if (map.isEmpty()) sb.append(0).append('\n');
                else {
                    int key = map.firstKey();
                    List<Integer> list = map.get(key);
                    
                    Collections.sort(list);
                    
                    sb.append(list.get(0)).append('\n');
                    // 주소만 참조 -> 원본이 삭제됨
                    list.remove(0);
                    
                    if (list.isEmpty()) {
                        map.remove(key);
                    }
                }
            }
        }
        
        System.out.print(sb);
        br.close();
    }
}