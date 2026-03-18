import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String st;
        
        while ((st = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(st));
            int[] arr = new int[n];
            
            arr = CantorSet(arr, arr.length);
            
            for (int i = 0; i < n; i++) {
                sb.append(arr[i] == 0 ? "-" : " ");
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static int[] CantorSet(int[] arr, int len) {
        if (len == 1) return arr;
        
        for (int i = 0; i < arr.length; i += len) {
            int start = len / 3;
            int finish = len / 3 * 2;
            
            for (int j = i + start; j < i + finish; j++) {
                arr[j] = 1;
            }
        }
        return CantorSet(arr, len / 3);
    }
}