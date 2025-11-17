import java.util.Scanner;

public class Main {
    public static void main(String[] str) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int answer = A + B;
        
        System.out.println(A+B);
        
        sc.close();
    }
}