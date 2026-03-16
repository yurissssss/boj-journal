import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int order = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if (num == order) order++;
            else stack.push(num);
            
            while (!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            }
        }
        
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
        
        br.close();
    }
}