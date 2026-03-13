import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            
            if (st[1].equals("enter")) set.add(st[0]);
            else set.remove(st[0]);
        }
        
        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (String s : list) {
            bw.write(s + '\n');
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}