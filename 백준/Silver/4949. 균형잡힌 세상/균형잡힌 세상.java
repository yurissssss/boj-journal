import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String st = " ";
        
        while (!(st = br.readLine()).equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isOk = true;
            
            for (char c : st.toCharArray()) {
                if (c == '(' || c == '[') stack.push(c);
                else if (c == ')') {
                    
                    /*
                    ArrayDeque<Character>에서 peek()는 비어 있으면 null을 반환
                     -> 비어있는지 확인 안 하면 Character와 char 비교 과정에서 문제가 날 수 🅾️
                     --> 백준에서는 보통 isEmpty() 먼저 확인!
                    */
                    
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isOk = false;
                        break;
                    }
                    else stack.pop();
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isOk = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            
            if (!stack.isEmpty()) isOk = false;
            
            sb.append(isOk ? "yes" : "no").append('\n');
        }
        
        System.out.println(sb);
        
        br.close();
    }
}