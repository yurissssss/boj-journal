/* 📌 Scanner 사용

import java.util.Scanner;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        String st = "??!";
        
        System.out.println(sc.next() + st);
        
        sc.close();
    }
}
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] str) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String st = "??!";
        
        String s = br.readLine();
        
        br.close();
        
        System.out.println(s + st);
    }
}
