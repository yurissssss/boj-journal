import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        long n = Long.parseLong(br.readLine());
        
        /*
        창문이 열고 닫힘 = 약수의 개수만큼
        - k번 창문 -> (1, 2, 3, 4, 6, 12) 6번 열고 닫힘
        - 보통 약수는 짝 맞춰서 존재하므로 짝수개 존재 -> 마지막엔 닫힘
        - 예외) 완전제곱수 -> k = 9 -> (1, 3, 9) 마지막에 열림
        => 완전제곱수의 개수만 찾으면 됨
        ==> 1 ~ k 사이의 완전제곱수 = √n의 정수부분
        */
        
        System.out.println((long)Math.sqrt(n));
        
        br.close();
    }
}