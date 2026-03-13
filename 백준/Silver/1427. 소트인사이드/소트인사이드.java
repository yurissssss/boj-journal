import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        
        while (n > 0) {
            arr.add(n % 10);
            
            n /= 10;
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
        }
        
        br.close();
    }
}