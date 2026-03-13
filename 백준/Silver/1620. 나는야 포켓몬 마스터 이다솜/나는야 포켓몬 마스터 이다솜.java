import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());  // 포켓몬 개수
        int m = Integer.parseInt(st.nextToken());  // 문제 개수
        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            nameMap.put(i + 1, name);  // 문제에서는 포켓몬 번호가 1부터 시작
            numMap.put(name, i + 1);
        }
        
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            
            if (Character.isDigit(name.charAt(0))) {
                int num = Integer.parseInt(name);
                
                bw.write(nameMap.get(num) + '\n');
            } else {
                bw.write(numMap.get(name) + "\n");
            }
        }
        
        
        bw.flush();
        br.close();
        bw.close();
    }
}