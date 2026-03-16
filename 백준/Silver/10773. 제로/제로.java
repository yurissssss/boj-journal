import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num == 0) stack.pop();
            else stack.push(num);
        }
        
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
        
        br.close();
    }
}