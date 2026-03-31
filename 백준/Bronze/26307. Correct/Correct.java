import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int HH = Integer.parseInt(st.nextToken());
        int MM = Integer.parseInt(st.nextToken());
        
        System.out.print((HH - 9) * 60 + MM);
        br.close();
    }
}