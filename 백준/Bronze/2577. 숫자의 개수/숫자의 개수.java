import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());
        
        String prod = Long.toString(a * b * c);
        int[] nums = new int[10];
        
        for (char ch : prod.toCharArray()) {
            nums[ch - '0']++;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }
        
        br.close();
    }
}