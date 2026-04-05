import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        System.out.print(dfs(n) + " " + (n - 2));
        br.close();
    }
    
    private static int dfs (int n) {
        if (n == 1 || n == 2) return 1;
        
        return dfs(n - 1) + dfs(n - 2);
    }
}