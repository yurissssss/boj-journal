import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 하노이 탑의 이동 횟수는 2^n - 1
        // <<: 비트 단위 왼쪽 시프트(Bitwise Left Shift) 연산자
        // - 정수의 이진수 표현을 지정된 비트 수만큼 왼쪽으로 밀고 빈자리를 0으로 채워 값을 배 증가시키는 역할
        // -> 1 << n = 2^n
        sb.append((1 << n) - 1).append('\n');
        
        hanoi(n, 1, 2, 3);
        
        System.out.print(sb);
        
        br.close();
    }
    
    // hanoi(원판개수, 시작기둥, 보조기둥, 목표기둥)
    private static void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        
        // 마지막 원판을 제외한 나머지 원판들을 보조기둥에 위치 시키기
        hanoi(n - 1, from, to, via);
        // 마지막 원판을 목표기둥으로 이동
        sb.append(from).append(' ').append(to).append('\n');
        // 나머지 원판들도 목표기둥으로 이동
        hanoi(n - 1, via, from, to);
    }
}