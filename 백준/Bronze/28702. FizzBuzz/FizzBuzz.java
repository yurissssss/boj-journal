import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        
        int answer = 0;
        
        if (!s1.equals("Fizz") && !s1.equals("Buzz") && !s1.equals("FizzBuzz")) {
            answer = Integer.parseInt(s1) + 3;
        } else if (!s2.equals("Fizz") && !s2.equals("Buzz") && !s2.equals("FizzBuzz")) {
            answer = Integer.parseInt(s2) + 2;
        } else answer = Integer.parseInt(s3) + 1;
        
        if (answer % 3 == 0 && answer % 5 == 0) {
            System.out.print("FizzBuzz");
        } else if (answer % 3 == 0) {
            System.out.print("Fizz");
        } else if (answer % 5 == 0) {
            System.out.print("Buzz");
        } else {
            System.out.print(answer);
        }
        
        br.close();
    }
}