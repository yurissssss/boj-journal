import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  //수열 개수 입력받기
        int A[] = new int[N];  //입력받은 수열을 저장할 배열

        //수열 입력받기
        for (int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        //연산 기록 - 빠른 문자열 처리
        StringBuilder sb = new StringBuilder();

        //오름차순으로 push할 숫자 - 1부터 시작
        int num = 1;
        //수열을 만들 수 있는지 판단
        boolean result = true;

        for (int i=0; i<A.length; i++) {
            //현재 수열의 수 - 이번에 만들어야 할 수 (목표 숫자)
            int element = A[i];
            //1️⃣ 현재 수열 값 >= 오름차순 자연수 (현재 목표 숫자가 아직 스택에 안 들어간 경우)
            if (element >= num) {
                //값이 같아질 때까지 push() 수행
                while (element >= num) {
                    stack.push(num++);
                    sb.append("+\n");  //push 연산 기록
                }
                //목표 숫자에 도달 -> pop
                stack.pop();
                sb.append("-\n");  //pop 연산 기록
            }
            //2️⃣ 현재 수열 값 < 오름차순 자연수 (현재 목표 숫자가 이미 스택 안에 있는 경우)
            else {
                int n = stack.pop();  //스택에서 숫자 꺼내기

                //만약 꺼낸 숫자(top)가 필요한 숫자보다 크면 수열을 출력할 수 X
                // (LIFO구조 -> pop 순서 바꿀 수 X -> 원하는 순서대로 꺼낼 수 X)
                // -> NO
                if (n > element) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    //원하는 숫자와 일치 -> 정상적인 pop
                    sb.append("-\n");
                }
            }
        }
        //수열을 성공적으로 만들었다면 결과 출력
        if (result) System.out.println(sb.toString());
    }
}
