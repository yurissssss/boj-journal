import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        
        System.out.println(n * (n - 1) / 2);
        System.out.println(2);
    }
}