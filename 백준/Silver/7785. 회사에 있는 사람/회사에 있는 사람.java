import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        // 자동으로 역순정렬 유지
        
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            
            if (st[1].equals("enter")) set.add(st[0]);
            else set.remove(st[0]);
        }
        
        for (String s : set) {
            bw.write(s + '\n');
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}