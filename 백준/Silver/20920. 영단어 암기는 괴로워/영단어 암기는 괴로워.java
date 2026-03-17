import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            
            if (word.length() >= m) {
                // 해당 word에 대한 기존 값 가져오거나 
                // 0으로 기본값 설정 후 +1 증가
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        
        Collections.sort(list, (a, b) -> {
            // 빈도수가 다를 경우 -> 빈도가 많은 순으로 정렬
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            
            // 단어의 길이가 다를 경우 -> 길이가 긴 순으로 정렬
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            
            // 알파벳 순으로 정렬
            return a.compareTo(b);
        });
        
        for (String s : list) {
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}