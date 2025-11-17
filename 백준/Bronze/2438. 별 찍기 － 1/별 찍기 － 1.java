import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int a = 0;
        
        while(a < n) {
            a++;
            for (int i = 1; i <= a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}